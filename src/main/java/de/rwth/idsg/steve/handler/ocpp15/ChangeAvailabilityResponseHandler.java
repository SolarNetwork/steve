package de.rwth.idsg.steve.handler.ocpp15;

import de.rwth.idsg.steve.handler.AbstractOcppResponseHandler;
import de.rwth.idsg.steve.ocpp.ws.data.OcppJsonError;
import de.rwth.idsg.steve.web.RequestTask;
import ocpp.cp._2012._06.ChangeAvailabilityResponse;

import javax.xml.ws.Response;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/**
 * @author Sevket Goekay <goekay@dbis.rwth-aachen.de>
 * @since 29.12.2014
 */
public class ChangeAvailabilityResponseHandler extends AbstractOcppResponseHandler<ChangeAvailabilityResponse> {

    public ChangeAvailabilityResponseHandler(RequestTask requestTask, String chargeBoxId) {
        super(requestTask, chargeBoxId);
    }

    @Override
    public void handleResult(ChangeAvailabilityResponse response) {
        requestTask.addNewResponse(chargeBoxId, response.getStatus().value());
    }
}
