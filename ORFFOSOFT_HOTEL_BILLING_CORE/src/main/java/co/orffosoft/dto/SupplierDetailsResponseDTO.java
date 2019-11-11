package co.orffosoft.dto;

import lombok.Data;

@Data
public class SupplierDetailsResponseDTO {

    private Long supplierId;

    private String supplierName;

    private Long businessTypeId;

    private Long supplierTypeId;

    private String accountNumber;


}
