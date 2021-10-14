//package com.gardenhouse.gardenhousemanager.live;
//
//import com.gardenhouse.gardenhousemanager.model.Basil;
//import com.gardenhouse.gardenhousemanager.service.BasilInfoService;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BasilLogicLiveServiceImpl implements BasilLogicLiveService{
//
//    private BasilInfoService basilInfoService;
//    private LiveService liveService;
//    private Basil basil;
//
//    @Override
//    public void sow() {
//        //TODO added and create method sow!
//    }
//
//    @Override
//    public Basil showParameters() {
//        return new Basil();
//    }
//
//    @Override
//    public void choiceMethodOfPlanting() {
//       //TODO implementation method planting Basil!
//    }
//
//    @Override
//    public Basil waterIt(double waterConsumption) {
//        Basil basil = new Basil();
//        double conditionOfWater = basil.getWaterConsumption();
//        double wa = conditionOfWater + waterConsumption;
//        basil.setWaterConsumption(wa);
//        return basil;
//    }
//}
