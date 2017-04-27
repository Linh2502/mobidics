package org.mobidics.api.viewmodel.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Long Bui on 27.04.17.
 * E-Mail: giaolong.bui@student.fhws.de
 */
public class EntityFieldParser
{
    private static Map<String, String> socialFormMap = new HashMap<>();
    private static Map<String, String> courseTypeMap = new HashMap<>();
    private static Map<String, String> phasesMap = new HashMap<>();
    private static Map<String, String> subphasesMap = new HashMap<>();

    static
    {
        socialFormMap.put("0", "Plenum interaktiv");
        socialFormMap.put("1", "Partner/Gruppenarbeit");
        socialFormMap.put("2", "Plenum untereinander");
        socialFormMap.put("3", "Einzelarbeit");
        socialFormMap.put("4", "Plenum frontal");

        courseTypeMap.put("0", "Seminar");
        courseTypeMap.put("1", "Übung");
        courseTypeMap.put("2", "Vorlesung");

        phasesMap.put("0", "(Lern-)Atmosphäre fördern");
        phasesMap.put("1", "Ausrichten");
        phasesMap.put("2", "Vorwissen aktivieren");
        phasesMap.put("3", "Informieren");
        phasesMap.put("4", "Verarbeiten");
        phasesMap.put("5", "Auswerten");

        subphasesMap.put("0", "Auf Thema einstimmen / Sensibilisieren");
        subphasesMap.put("1", "Vorwissen erfragen");
        subphasesMap.put("2", "Inhalte wiederholen");
        subphasesMap.put("3", "Wissensinput");
        subphasesMap.put("4", "Wissen generieren");
        subphasesMap.put("5", "Kritische Auseinandersetzung mit Wissen");
        subphasesMap.put("6", "Auflockerung");
        subphasesMap.put("7", "Wissen anwenden / umsetzen");
        subphasesMap.put("8", "Wissen festigen");
        subphasesMap.put("9", "Wissen abfragen");
        subphasesMap.put("10", "Lernprozess reflektieren");
        subphasesMap.put("11", "Kennenlernen");
        subphasesMap.put("12", "Persönlicher Austausch (Erfahrung)");
        subphasesMap.put("13", "Gruppengefühl stärken");
        subphasesMap.put("14", "Ausklang");
        subphasesMap.put("18", "Feedback einholen");
        subphasesMap.put("19", "Auflockerung");
    }

    public static String parseSocialForm(String string)
    {
        if (string != null)
        {
            String[] splitString = string.split(":");
            StringBuilder result = new StringBuilder();
            result.append(splitString[0]);
            for (String form : splitString)
            {
                result.append(", ").append(socialFormMap.get(form));
            }
            return result.toString();
        }
        return null;
    }

    public static String parseCourseType(String string)
    {
        if (string != null)
        {
            String[] splitString = string.split(":");
            StringBuilder result = new StringBuilder();
            result.append(splitString[0]);
            for (String form : splitString)
            {
                result.append(", ").append(courseTypeMap.get(form));
            }
            return result.toString();
        }
        return null;
    }

    public static String parsePhases(String string)
    {
        if (string != null)
        {
            String[] splitString = string.split(":");
            StringBuilder result = new StringBuilder();
            result.append(splitString[0]);
            for (String form : splitString)
            {
                result.append(", ").append(phasesMap.get(form));
            }
            return result.toString();
        }
        return null;
    }

    public static String parseSubphases(String string)
    {
        if (string != null)
        {
            String[] splitString = string.split(":");
            StringBuilder result = new StringBuilder();
            result.append(splitString[0]);
            for (String form : splitString)
            {
                result.append(", ").append(subphasesMap.get(form));
            }
            return result.toString();
        }
        return null;
    }
}
