package com.lhdn.einvoice;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonRootName(value = "EInvoice")
@JacksonXmlRootElement(localName = "EInvoice")
class EInvoice
{
	@JsonProperty(value = "ValidationDate")
	@JacksonXmlProperty(localName = "ValidationDate")
	private String validationDate;
	
	@JsonProperty(value = "UIN")
	@JacksonXmlProperty(localName = "UIN")
	private String uin;
	
	@JsonProperty(value = "QRLink")
	@JacksonXmlProperty(localName = "QRLink")
	private String qrLink;
	
	@JsonProperty(value = "Version")
	@JacksonXmlProperty(localName = "Version")
	private int version;
	
	@JsonProperty(value = "Type")
	@JacksonXmlProperty(localName = "Type")
	private String type;
	
	@JsonProperty(value = "Classification")
	@JacksonXmlProperty(localName = "Classification")
	private String classification;
	
	@JsonProperty(value = "DocumentNo")
	@JacksonXmlProperty(localName = "DocumentNo")
	private String documentNo;
	
	@JsonProperty(value = "ExistingDocumentNo")
	@JacksonXmlProperty(localName = "ExistingDocumentNo")
	private String existingDocumentNo;
	
	@JsonProperty(value = "DocumentDate")
	@JacksonXmlProperty(localName = "DocumentDate")
	private String documentDate;
	
	@JsonProperty(value = "CurrencyCode")
	@JacksonXmlProperty(localName = "CurrencyCode")
	private String currencyCode;
	
	@JsonProperty(value = "ExchangeRate")
	@JacksonXmlProperty(localName = "ExchangeRate")
	private String exchangeRate;
	
	@JsonProperty(value = "BillingFrequency")
	@JacksonXmlProperty(localName = "BillingFrequency")
	private String billingFrequency;
	
	@JsonProperty("BillingPeriod")
	@JacksonXmlProperty(localName = "BillingPeriod")
	private String billingPeriod;
	
	@JsonProperty("PaymentMode")
	@JacksonXmlProperty(localName = "PaymentMode")
	private String paymentMode;

	@JsonProperty("SupplierBankAccNo")	
	@JacksonXmlProperty(localName = "SupplierBankAccNo")
	private String supplierBankAccNo;

	@JsonProperty("PaymentTerms")
	@JacksonXmlProperty(localName = "PaymentTerms")
	private String paymentTerms;
		
	@JsonProperty("PaymentAmount")
	@JacksonXmlProperty(localName = "PaymentAmount")
	private int paymentAmount;
	
	@JsonProperty("PaymentDate")
	@JacksonXmlProperty(localName = "PaymentDate")
	private String paymentdDate;
	
	@JsonProperty("PaymentRefNo")
	@JacksonXmlProperty(localName = "PaymentRefNo")
	private String paymentRefNo;
	
	@JsonProperty("BillRefNo")
	@JacksonXmlProperty(localName = "BillRefNo")
	private String billRefNo;
	
	@JsonProperty("Supplier")
	@JacksonXmlProperty(localName = "Supplier")
	private Supplier supplier;
	
	@JsonProperty("Buyer")
	@JacksonXmlProperty(localName = "Buyer")
	private Buyer buyer;
	
	@JsonProperty("BusinessActivityDesc")
	@JacksonXmlProperty(localName = "BusinessActivityDesc")
	private String businessActivityDesc;
	
	@JsonProperty("ShippingRecipient")
	@JacksonXmlProperty(localName = "ShippingRecipient")
	private ShippingRecipient shippingRecipient;
		
	@JsonProperty("RefCustomerForm2")
	@JacksonXmlProperty(localName = "RefCustomerForm2")
	private String refCustomerForm2;
	
	@JsonProperty("CountryOrigin")
	@JacksonXmlProperty(localName = "CountryOrigin")
	private String countryOrigin;
	
	@JsonProperty("ChargesDetail")
	@JacksonXmlProperty(localName = "ChargesDetail")
	private String chargesDetail;
	
	@JsonProperty("Total")
	@JacksonXmlProperty(localName = "Total")
	private Total total;
	
	@JsonProperty("IssuerDigitalSignature")
	@JacksonXmlProperty(localName = "IssuerDigitalSignature")
	private String issuerDigitalSignature;
	
	@JsonProperty("InvoiceLines")
	@JacksonXmlProperty(localName = "InvoiceLines")
	private InvoiceLines invoiceLines;

}

class Supplier
{
	@JsonProperty("SupplierTin")
	@JacksonXmlProperty(localName = "SupplierTin")
	private String supplierTin;

	@JsonProperty("SupplierID")
	@JacksonXmlProperty(localName = "SupplierID")
	private String supplierId;

	@JsonProperty("SupplierSST")
	@JacksonXmlProperty(localName = "SupplierSST")
	private int supplierSst;

	@JsonProperty("SupplierTourismTax")
	@JacksonXmlProperty(localName = "SupplierTourismTax")
	private String supplierTourismTax;

	@JsonProperty("SupplierName")
	@JacksonXmlProperty(localName = "SupplierName")
	private String supplierName;
	
	@JsonProperty("SupplierAddress")
	@JacksonXmlProperty(localName = "SupplierAddress")
	private String supplieraddress;

	@JsonProperty("SupplierEmail")
	@JacksonXmlProperty(localName = "SupplierEmail")
	private String supplierEmail;

	@JsonProperty("SupplierContactNo")
	@JacksonXmlProperty(localName = "SupplierContactNo")
	private String supplierContactNo;

	@JsonProperty("MsicCode")
	@JacksonXmlProperty(localName = "MsicCode")
	private String msicCode;

}

class Buyer
{
	@JsonProperty("BuyerTin")
	@JacksonXmlProperty(localName = "BuyerTin")
	private String buyerTin;
	
	@JsonProperty("BuyerID")
	@JacksonXmlProperty(localName = "BuyerID")
	private String buyerId;
	
	@JsonProperty("BuyerSST")
	@JacksonXmlProperty(localName = "BuyerSST")
	private int buyerSst;
	
	@JsonProperty("BuyerName")
	@JacksonXmlProperty(localName = "BuyerName")
	private String buyerName;
	
	@JsonProperty("BuyerAddress")
	@JacksonXmlProperty(localName = "BuyerAddress")
	private String buyerAddress;
	
	@JsonProperty("BuyerEmail")
	@JacksonXmlProperty(localName = "BuyerEmail")
	private String buyerEmail;
	
	@JsonProperty("BuyerContactNo")
	@JacksonXmlProperty(localName = "BuyerContactNo")
	private String buyerContactNo;
}

class ShippingRecipient
{
	@JsonProperty("ShippingRecipientName")
	@JacksonXmlProperty(localName = "ShippingRecipientName")
	private String shippingRecipientName;
	
	@JsonProperty("ShippingRecipientAddress")
	@JacksonXmlProperty(localName = "ShippingRecipientAddress")
	private String shippingRecipientAddress;
	
	@JsonProperty("ShippingRecipientTin")
	@JacksonXmlProperty(localName = "ShippingRecipientTin")
	private String shippingRecipientTin;
	
	@JsonProperty("ShippingRecipientRegNo")
	@JacksonXmlProperty(localName = "ShippingRecipientRegNo")
	private String shippingRecipientRegNo;
	
	@JsonProperty("RefCustomerForm1")
	@JacksonXmlProperty(localName = "RefCustomerForm1")
	private String refCustomerForm1;
	
	@JsonProperty("FTAInformation")
	@JacksonXmlProperty(localName = "FTAInformation")
	private String ftaInformation;
	
	@JsonProperty("Incoterms")
	@JacksonXmlProperty(localName = "Incoterms")
	private String incoterms;
	
	@JsonProperty("AuthorisationNumber")
	@JacksonXmlProperty(localName = "AuthorisationNumber")
	private String authorisationNumber;
}

class Total
{
	@JsonProperty("TotalExcludeTax")
	@JacksonXmlProperty(localName = "TotalExcludeTax")
	private int totalExcludeTax;

	@JsonProperty("TotalIncludeTax")
	@JacksonXmlProperty(localName = "TotalIncludeTax")
	private double totalIncludeTax;
}

class InvoiceLines
{
	@JsonProperty("Line")
	@JacksonXmlProperty(localName = "Line")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<Line> line;
}

class Line
{
	@JsonProperty("ProductTariffCode")
	@JacksonXmlProperty(localName = "ProductTariffCode")
	private String productTariffCode;
	
	@JsonProperty("ProductDesc")
	@JacksonXmlProperty(localName = "ProductDesc")
	private String productDesc;
	
	@JsonProperty("UnitPrice")
	@JacksonXmlProperty(localName = "UnitPrice")
	private double unitPrice;		
	
	@JsonProperty("TaxType")
	@JacksonXmlProperty(localName = "TaxType")
	private String taxType;
	
	@JsonProperty("TaxRate")
	@JacksonXmlProperty(localName = "TaxRate")
	private int taxRate;
	
	@JsonProperty("TaxExemptionDetails")
	@JacksonXmlProperty(localName = "TaxExemptionDetails")
	private String taxExemptionDetails;
	
	@JsonProperty("TaxAmountExempted")
	@JacksonXmlProperty(localName = "TaxAmountExempted")
	private double taxAmountExempted;
	
	@JsonProperty("SubTotal")
	@JacksonXmlProperty(localName = "SubTotal")
	private double subTotal;
	
	@JsonProperty("Quantity")
	@JacksonXmlProperty(localName = "Quantity")
	private int quantity;
	
	@JsonProperty("Measurement")
	@JacksonXmlProperty(localName = "Measurement")
	private String measurement;
	
	@JsonProperty("DiscountRate")
	@JacksonXmlProperty(localName = "DiscountRate")
	private int discountRate;
	
	@JsonProperty("DiscountAmount")
	@JacksonXmlProperty(localName = "DiscountAmount")
	private int discountAmount;
}