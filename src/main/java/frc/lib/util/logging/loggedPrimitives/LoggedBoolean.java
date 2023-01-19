// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.lib.util.logging.loggedPrimitives;

import java.util.function.Supplier;

import edu.wpi.first.util.datalog.BooleanLogEntry;
import edu.wpi.first.util.datalog.DoubleLogEntry;
import edu.wpi.first.wpilibj.DataLogManager;
import frc.lib.util.logging.LoggedContainer;
import frc.lib.util.logging.Logger.LoggingLevel;

/** Add your docs here. */
public class LoggedBoolean extends LoggedPrimitive<Boolean>{

    private BooleanLogEntry logEntry;

    public LoggedBoolean(String name, LoggingLevel level, String prefix) {
        super(name, level, prefix);
    }

    public LoggedBoolean(String name, LoggingLevel level, String prefix, Supplier<Boolean> supplier) {
        super(name, level, prefix, supplier);
    }

    public LoggedBoolean(String name, LoggingLevel level, LoggedContainer subsystem) {
        super(name, level, subsystem);
    }

    public LoggedBoolean(String name, LoggingLevel level, LoggedContainer subsystem, Supplier<Boolean> supplier) {
        super(name, level, subsystem, supplier);
    }

    @Override
    protected void initializeOnboardLog(String name, String prefix) {
        logEntry = new BooleanLogEntry(DataLogManager.getLog(), getOnboardLogName(name, prefix));
    }

    @Override
    protected void logOnboard(long timestamp, Boolean value) {
        logEntry.append(value, timestamp);
        
    }

    @Override
    protected void logShuffleboard(Boolean value) {
        shuffleboardEntry.setBoolean(value);
    }

   

}
