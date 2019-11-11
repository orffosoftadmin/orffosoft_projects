package co.orffosoft.core.util;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.util.StringUtils;

import co.orffosoft.dto.LoginResponseDTO;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TrackFilter implements Filter {

	TrackIdGenerationService trackIdGenerationService = new TrackIdGenerationService();

	// private static final String DEFAULT_PAGE = "/sessionerror.xhtml";
	private static final String DEFAULT_PAGE = "/login.xhtml";
	private static final String DEFAULT_HOME_PAGE = "/login.xhtml";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < 8; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession httpSession = req.getSession();
		LoginResponseDTO loginResponseDto = (LoginResponseDTO) ((HttpServletRequest) request).getSession()
				.getAttribute("UserObject");
		String trackId = trackIdGenerationService.generateTackId(httpSession.getId());
		ThreadContext.put("TrackId", trackId);
		String path = req.getRequestURI().substring(req.getContextPath().length());

		//log.info("Path: " + path);
		log.info("trackId: " + trackId);

		try {
			if (httpSession != null && StringUtils.isEmpty(trackId)) {
				trackId = sb.toString();
				ThreadLocalConfig.setId(trackId);
			}

			log.info("trackId set: " + trackId);

			if (path.contains("/pages/") || path.contains("/WEB-INF/tiles/")) {

				log.info("path.contains(\"/pages/\") >>>> " + path);

				String contextPath = ((HttpServletRequest) request).getContextPath();
				if (!StringUtils.isEmpty((Object) loginResponseDto)) {
					if (!StringUtils.isEmpty((Object) loginResponseDto.getUserDetails())) {

						log.info("!StringUtils.isEmpty((Object) loginResponseDto.getUserDetails())");

						loginResponseDto.setPrePath(req.getRequestURI().substring(req.getContextPath().length()));
						chain.doFilter(request, response);
					} else {
						res.sendRedirect(contextPath + DEFAULT_PAGE);
					}
				} else if (path.contains(DEFAULT_HOME_PAGE)) {
					res.sendRedirect(contextPath + DEFAULT_HOME_PAGE);
				} else {
					log.info((Object) "session expired");
					if ("partial/ajax".equals(req.getHeader("Faces-Request"))) {
						response.setContentType("text/html");
						response.getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").printf(
								"<partial-response><redirect url=\"%s\"></redirect></partial-response>",
								contextPath + DEFAULT_PAGE);
					} else {
						res.sendRedirect(contextPath + DEFAULT_PAGE);
					}
				}

			} else if (path.equalsIgnoreCase("/")) {
				log.info("path.equalsIgnoreCase(\"/\")");
				String contextPath = ((HttpServletRequest) request).getContextPath();
				res.sendRedirect(contextPath + DEFAULT_HOME_PAGE);
				chain.doFilter(req, res);
			} else {
				log.info("chain.doFilter");
				chain.doFilter(req, res);
			}

		} catch (Exception e) {
			log.info("Path inside catch: " + path);
			log.info("trackId inside catch: " + trackId);
			log.error("Exception at TrackFilter.doFilter()", e);
		}

	}

	@Override
	public void destroy() {

	}
}