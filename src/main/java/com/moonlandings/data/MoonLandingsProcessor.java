package com.moonlandings.data;
import com.moonlandings.model.MoonLandingsInput;
import com.moonlandings.model.moonlandings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class MoonLandingsProcessor implements ItemProcessor<MoonLandingsInput, moonlandings> {



    @Override
    public moonlandings process(MoonLandingsInput moonLandingsInput) throws Exception  {

            moonlandings moonLandings = new moonlandings();
            moonLandings.setMission(moonLandingsInput.getMission());
            moonLandings.setSpacecraft(moonLandingsInput.getSpacecraft());
            moonLandingsInput.getLaunch_date();
            if( !(moonLandingsInput.getLaunch_date().equalsIgnoreCase("launchdate")) && !moonLandingsInput.getLaunch_date().isEmpty()) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yy");

                LocalDate localDate = LocalDate.parse(moonLandingsInput.getLaunch_date(), formatter);
                moonLandings.setLaunchDate(localDate);


            }
            moonLandings.setCarrierRocket(moonLandingsInput.getCarrier_rocket());
            moonLandings.setOperator(moonLandingsInput.getOperator());
            moonLandings.setMissionType(moonLandingsInput.getMission_type());
            moonLandings.setOutcome(moonLandingsInput.getOutcome());
            moonLandings.setAdditionalInformation(moonLandingsInput.getAdditional_information());
            return moonLandings;




    }

}
