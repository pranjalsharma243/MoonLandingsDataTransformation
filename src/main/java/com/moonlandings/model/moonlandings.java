package com.moonlandings.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public class moonlandings {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
    private String mission;
    private String spacecraft;
    private LocalDate launchDate;
    private String carrierRocket;


    private String operator;
    private String missionType;
    private String outcome;
    private String additionalInformation;
    private int number;
    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public String getSpacecraft() {
        return spacecraft;
    }

    public void setSpacecraft(String spacecraft) {
        this.spacecraft = spacecraft;
    }


    public String getCarrierRocket() {
        return carrierRocket;
    }

    public void setCarrierRocket(String carrierRocket) {
        this.carrierRocket = carrierRocket;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getMissionType() {
        return missionType;
    }

    public void setMissionType(String missionType) {
        this.missionType = missionType;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "moonlandings{" +
                "id=" + id +
                ", mission='" + mission + '\'' +
                ", spacecraft='" + spacecraft + '\'' +
                ", launchDate=" + launchDate +
                ", carrierRocket='" + carrierRocket + '\'' +
                ", operator='" + operator + '\'' +
                ", missionType='" + missionType + '\'' +
                ", outcome='" + outcome + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
