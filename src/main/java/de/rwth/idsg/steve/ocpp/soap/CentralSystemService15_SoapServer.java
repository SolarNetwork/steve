package de.rwth.idsg.steve.ocpp.soap;

import de.rwth.idsg.steve.ocpp.OcppProtocol;
import de.rwth.idsg.steve.service.CentralSystemService15_Service;
import lombok.extern.slf4j.Slf4j;
import ocpp.cs._2012._06.*;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.JAXWSAConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.BindingType;
import javax.xml.ws.Response;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.soap.SOAPBinding;
import java.util.concurrent.Future;

/**
 * Service implementation of OCPP V1.5
 * 
 * @author Sevket Goekay <goekay@dbis.rwth-aachen.de>
 *  
 */
@Slf4j
@Service
@Addressing(enabled = true, required = true)
@BindingType(value = SOAPBinding.SOAP12HTTP_BINDING)
@WebService(
        serviceName = "CentralSystemService",
        portName = "CentralSystemServiceSoap12",
        targetNamespace = "urn://Ocpp/Cs/2012/06/",
        endpointInterface = "ocpp.cs._2012._06.CentralSystemService")
public class CentralSystemService15_SoapServer implements CentralSystemService {

    @Resource private WebServiceContext webServiceContext;
    @Autowired private CentralSystemService15_Service service;

    public BootNotificationResponse bootNotification(BootNotificationRequest parameters, String chargeBoxIdentity) {

        // Get the Address value from WS-A Header
        MessageContext messageContext = webServiceContext.getMessageContext();
        AddressingProperties addressProp = (AddressingProperties) messageContext.get(JAXWSAConstants.ADDRESSING_PROPERTIES_INBOUND);
        String endpointAddress = addressProp.getFrom().getAddress().getValue();

        return service.bootNotification(parameters, chargeBoxIdentity, OcppProtocol.V_15_SOAP, endpointAddress);
    }

    public FirmwareStatusNotificationResponse firmwareStatusNotification(FirmwareStatusNotificationRequest parameters,
                                                                         String chargeBoxIdentity) {
        return service.firmwareStatusNotification(parameters, chargeBoxIdentity);
    }

    public StatusNotificationResponse statusNotification(StatusNotificationRequest parameters, String chargeBoxIdentity) {
        return service.statusNotification(parameters, chargeBoxIdentity);
    }

    public MeterValuesResponse meterValues(MeterValuesRequest parameters, String chargeBoxIdentity) {
        return service.meterValues(parameters, chargeBoxIdentity);
    }

    public DiagnosticsStatusNotificationResponse diagnosticsStatusNotification(DiagnosticsStatusNotificationRequest parameters,
                                                                               String chargeBoxIdentity) {
        return service.diagnosticsStatusNotification(parameters, chargeBoxIdentity);
    }

    public StartTransactionResponse startTransaction(StartTransactionRequest parameters, String chargeBoxIdentity) {
        return service.startTransaction(parameters, chargeBoxIdentity);
    }

    public StopTransactionResponse stopTransaction(StopTransactionRequest parameters, String chargeBoxIdentity) {
        return service.stopTransaction(parameters, chargeBoxIdentity);
    }

    public HeartbeatResponse heartbeat(HeartbeatRequest parameters, String chargeBoxIdentity) {
        return service.heartbeat(parameters, chargeBoxIdentity);
    }

    public AuthorizeResponse authorize(AuthorizeRequest parameters, String chargeBoxIdentity) {
        return service.authorize(parameters, chargeBoxIdentity);
    }

    public DataTransferResponse dataTransfer(DataTransferRequest parameters, String chargeBoxIdentity) {
        return service.dataTransfer(parameters, chargeBoxIdentity);
    }

    // -------------------------------------------------------------------------
    // No-op
    // -------------------------------------------------------------------------

    @Override
    public Response<HeartbeatResponse> heartbeatAsync(HeartbeatRequest parameters, String chargeBoxIdentity) {
        return null;
    }

    @Override
    public Future<?> heartbeatAsync(HeartbeatRequest parameters, String chargeBoxIdentity, AsyncHandler<HeartbeatResponse> asyncHandler) {
        return null;
    }

    @Override
    public Response<StartTransactionResponse> startTransactionAsync(StartTransactionRequest parameters, String chargeBoxIdentity) {
        return null;
    }

    @Override
    public Future<?> startTransactionAsync(StartTransactionRequest parameters, String chargeBoxIdentity, AsyncHandler<StartTransactionResponse> asyncHandler) {
        return null;
    }

    @Override
    public Response<StopTransactionResponse> stopTransactionAsync(StopTransactionRequest parameters, String chargeBoxIdentity) {
        return null;
    }

    @Override
    public Future<?> stopTransactionAsync(StopTransactionRequest parameters, String chargeBoxIdentity, AsyncHandler<StopTransactionResponse> asyncHandler) {
        return null;
    }

    @Override
    public Response<DiagnosticsStatusNotificationResponse> diagnosticsStatusNotificationAsync(DiagnosticsStatusNotificationRequest parameters, String chargeBoxIdentity) {
        return null;
    }

    @Override
    public Future<?> diagnosticsStatusNotificationAsync(DiagnosticsStatusNotificationRequest parameters, String chargeBoxIdentity, AsyncHandler<DiagnosticsStatusNotificationResponse> asyncHandler) {
        return null;
    }

    @Override
    public Response<AuthorizeResponse> authorizeAsync(AuthorizeRequest parameters, String chargeBoxIdentity) {
        return null;
    }

    @Override
    public Future<?> authorizeAsync(AuthorizeRequest parameters, String chargeBoxIdentity, AsyncHandler<AuthorizeResponse> asyncHandler) {
        return null;
    }

    @Override
    public Response<BootNotificationResponse> bootNotificationAsync(BootNotificationRequest parameters, String chargeBoxIdentity) {
        return null;
    }

    @Override
    public Future<?> bootNotificationAsync(BootNotificationRequest parameters, String chargeBoxIdentity, AsyncHandler<BootNotificationResponse> asyncHandler) {
        return null;
    }

    @Override
    public Response<MeterValuesResponse> meterValuesAsync(MeterValuesRequest parameters, String chargeBoxIdentity) {
        return null;
    }

    @Override
    public Future<?> meterValuesAsync(MeterValuesRequest parameters, String chargeBoxIdentity, AsyncHandler<MeterValuesResponse> asyncHandler) {
        return null;
    }

    @Override
    public Response<FirmwareStatusNotificationResponse> firmwareStatusNotificationAsync(FirmwareStatusNotificationRequest parameters, String chargeBoxIdentity) {
        return null;
    }

    @Override
    public Future<?> firmwareStatusNotificationAsync(FirmwareStatusNotificationRequest parameters, String chargeBoxIdentity, AsyncHandler<FirmwareStatusNotificationResponse> asyncHandler) {
        return null;
    }

    @Override
    public Response<DataTransferResponse> dataTransferAsync(DataTransferRequest parameters, String chargeBoxIdentity) {
        return null;
    }

    @Override
    public Future<?> dataTransferAsync(DataTransferRequest parameters, String chargeBoxIdentity, AsyncHandler<DataTransferResponse> asyncHandler) {
        return null;
    }

    @Override
    public Response<StatusNotificationResponse> statusNotificationAsync(StatusNotificationRequest parameters, String chargeBoxIdentity) {
        return null;
    }

    @Override
    public Future<?> statusNotificationAsync(StatusNotificationRequest parameters, String chargeBoxIdentity, AsyncHandler<StatusNotificationResponse> asyncHandler) {
        return null;
    }
}
