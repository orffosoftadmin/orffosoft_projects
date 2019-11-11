package co.orffosoft.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.orffosoft.core.util.ErrorDescription;
import co.orffosoft.core.util.RestException;
import co.orffosoft.entity.SequenceConfig;
import co.orffosoft.enums.SequenceName;
import co.orffosoft.repository.SequenceConfigRepository;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SequenceConfigService {

	@Autowired
	SequenceConfigRepository sequenceConfigRepository;
	
	public String generateNextSequenceByName(SequenceName sequenceName) {
		return this.generateNextSequence(sequenceName.toString(), null);
	}
	
	public String generateNextSequenceByName(SequenceName sequenceName, String additionalValue) {
		return this.generateNextSequence(sequenceName.toString(), additionalValue);
	}

	private String generateNextSequence(String sequenceName, String additionalValue) {

		log.info("Generating Sequence for [" + sequenceName + "]");

		String generatedSequence = null;

		try {

			SequenceConfig sequenceConfig = sequenceConfigRepository.findBySequenceName(SequenceName.valueOf(sequenceName));

			if (sequenceConfig == null) {
				throw new RestException(ErrorDescription.SEQUENCE_CONFIG_NOT_EXIST);
			}

			generatedSequence = prepareSequence(sequenceConfig, additionalValue);

			sequenceConfig.setCurrentValue(sequenceConfig.getCurrentValue() + 1);

			sequenceConfigRepository.save(sequenceConfig);

			log.info("Generated Sequence : [" + generatedSequence + "]");

		} catch (Exception exception) {
			log.error("Exception ", exception);
		}

		return generatedSequence;
	}
	
	private void append(StringBuffer generatedSequence, String separator, String value) {
		if (generatedSequence.length() == 0) {
			generatedSequence.append(value.trim());
		} else {
			generatedSequence.append(separator);
			generatedSequence.append(value.trim());
		}
	}

	private String prepareSequence(SequenceConfig sequenceConfig, String additionalValue) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd");

		String date = simpleDateFormat.format(new Date());

		log.info("Current Date [" + date + "]");

		StringBuffer generatedSequence = new StringBuffer();

		String separator = "";

		if (sequenceConfig.getSeparator() != null && !sequenceConfig.getSeparator().trim().isEmpty()) {
			separator = sequenceConfig.getSeparator();
		}

		if (sequenceConfig.getPrefix() != null && !sequenceConfig.getPrefix().trim().isEmpty()) {
				append(generatedSequence, separator, sequenceConfig.getPrefix());
		}
	
		if(additionalValue != null && !additionalValue.trim().isEmpty()) {
			append(generatedSequence, separator, additionalValue);
		}

		if (sequenceConfig.getIsMonthRequired() != null && sequenceConfig.getIsMonthRequired().equals(true)) {
			String currentMonth = date.substring(date.indexOf("-") + 1, date.lastIndexOf("-"));
			append(generatedSequence, separator, currentMonth.toUpperCase());
		}

		if (sequenceConfig.getIsYearRequired() != null && sequenceConfig.getIsYearRequired().equals(true)) {
			String currentYear = date.substring(0, date.indexOf("-"));
			append(generatedSequence, separator, currentYear);
		}

		String codeSeparator = "";

		if (sequenceConfig.getCodeSeparator() != null && !sequenceConfig.getCodeSeparator().trim().isEmpty()) {
			codeSeparator = sequenceConfig.getCodeSeparator();
		}

		append(generatedSequence, codeSeparator, sequenceConfig.getCurrentValue().toString());

		if (sequenceConfig.getSuffix() != null && !sequenceConfig.getSuffix().trim().isEmpty()) {
			append(generatedSequence, separator, sequenceConfig.getSuffix());
		}

		return generatedSequence.toString();
	}


}
