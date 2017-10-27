package com.hueemulator.emulator;

import com.hueemulator.gui.View;

public class HueEmulator{
   
    public static void main(String args[]) {
        if(args.length > 0) {
            boolean autoStart = false;
            if (args.length > 1)
                autoStart = Boolean.parseBoolean(args[1]);
            new HueEmulator(args[0], autoStart);
        } else new HueEmulator(null, false);
    }
    
    public HueEmulator(String fileName, boolean autoStart) {
        Model model = new Model();
        
        //  Set Up the View (A JFrame, MenuBar and Console).
        View view = new View();
        
        // Bind the Model and View
        Controller controller = new Controller(model,view,fileName);
        view.getMenuBar().setController(controller);
        view.getGraphicsPanel().setController(controller);
        
        // Add all the Menu Listeners.
        controller.addMenuListeners();   
        
        // Add all the Property Frame Listeners.
        controller.addPropertiesListeners();        
        
        //  Model is needed here to paint Light Bulbs/ Show bulb information.
        view.getGraphicsPanel().setModel(model);


        if(autoStart) {
            view.getMenuBar().getStartButton().doClick();
        }
    }        
    
}