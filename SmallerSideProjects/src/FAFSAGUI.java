/**
 * Created by gvrousto on 11/3/15.
 */

import javax.swing.JOptionPane;

public class FAFSAGUI {
    public static void main(String[] args) {
        boolean passed = true;
        boolean isAccepted;
        boolean isSS;
        boolean SSNbool;
        boolean hasValid;
        boolean dependent;
        int age;
        int creditHours;
        double sIncome;
        double pIncome;
        do {
            JOptionPane.showMessageDialog(null, "Welcome to the FAFSA!", "Welcome", JOptionPane
                    .INFORMATION_MESSAGE);

            int isAcceptedStudent = JOptionPane.showOptionDialog(null, "Have you been accepted "
                            + "into a degree or undergraduate program?", "Program Acceptance",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            int isSSRegistered = JOptionPane.showOptionDialog(null, "Are you registered for " +
                            "the selective service?", "Selective Service", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            int hasSSN = JOptionPane.showOptionDialog(null, "Do you have a Social Security " +
                            "Number?", "Social Security Number", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            int hasValidResidency = JOptionPane.showOptionDialog(null, "Do you have Valid Residency " +
                            "status?", "Residency Status", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, null, null);
            do {
                String sAge = JOptionPane.showInputDialog(null, "How old are you?", "Age", JOptionPane
                        .QUESTION_MESSAGE);
                age = Integer.parseInt(sAge);
                passed = true;
                if (age < 0) {
                    JOptionPane.showMessageDialog(null, "Age cannot be a negative number.", "Error: " +
                                    "Age",
                            JOptionPane
                                    .ERROR_MESSAGE);
                    passed = false;
                }
            } while (!passed);
            do {
                String credit = JOptionPane.showInputDialog(null, "How many credit hours do you plan " +
                        "on" +
                        " taking?", "Credit Hours", JOptionPane
                        .QUESTION_MESSAGE);
                creditHours = Integer.parseInt(credit);
                passed = true;
                if (creditHours < 1 || creditHours > 24) {
                    JOptionPane.showMessageDialog(null, "Credit hours must be between 1 and 24, " +
                                    "inclusive.", "Error: Credit Hours",
                            JOptionPane
                                    .ERROR_MESSAGE);
                    passed = false;
                }
            } while (!passed);
            do {
                String studentIncome = JOptionPane.showInputDialog(null, "What is your total yearly " +
                                "income?",
                        "Student Income", JOptionPane
                                .QUESTION_MESSAGE);
                sIncome = Double.parseDouble(studentIncome);
                passed = true;
                if (sIncome < 0) {
                    JOptionPane.showMessageDialog(null, "Income cannot be a negative number.",
                            "Error: Student Income",
                            JOptionPane
                                    .ERROR_MESSAGE);
                    passed = false;
                }
            } while (!passed);
            do {
                String parIncome = JOptionPane.showInputDialog(null, "What is your parent's total " +
                                "yearly " +
                                "income?",
                        "Parent Income", JOptionPane
                                .QUESTION_MESSAGE);
                pIncome = Double.parseDouble(parIncome);
                passed = true;
                if (pIncome < 0) {
                    JOptionPane.showMessageDialog(null, "Income cannot be a negative number.",
                            "Error: Parent Income",
                            JOptionPane
                                    .ERROR_MESSAGE);
                    passed = false;
                }
            } while (!passed);
            int isDependent = JOptionPane.showOptionDialog(null, "Are you a dependent?", "Dependency",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            String[] standing = {"Freshman", "Sophomore", "Junior", "Senior", "Graduate"};
            String classStanding = (String) JOptionPane.showInputDialog(null, "What is your current " +
                    "class standing?", "Class Standing", JOptionPane.PLAIN_MESSAGE, null, standing, null);
            if (!classStanding.toUpperCase().equals("GRADUATE")) {
                classStanding = "UNDERGRADUATE";
            }

            if (isAcceptedStudent == JOptionPane.YES_OPTION) {
                isAccepted = true;
            } else {
                isAccepted = false;
            }
            if (isSSRegistered == JOptionPane.YES_OPTION) {
                isSS = true;
            } else {
                isSS = false;
            }
            if (hasSSN == JOptionPane.YES_OPTION) {
                SSNbool = true;
            } else {
                SSNbool = false;
            }
            if (hasValidResidency == JOptionPane.YES_OPTION) {
                hasValid = true;
            } else {
                hasValid = false;
            }
            if (isDependent == JOptionPane.YES_OPTION) {
                dependent = true;
            } else {
                dependent = false;
            }
            FAFSA Alexa = new FAFSA(isAccepted, isSS, SSNbool, hasValid, dependent, age, creditHours,
                    sIncome, pIncome, classStanding);
            double d0 = Alexa.calcFederalGrant();
            double d1 = Alexa.calcStaffordLoan();
            double d2 = Alexa.calcWorkStudy();
            double d3 = Alexa.calcFederalAidAmount();
            JOptionPane.showMessageDialog(null, "Loans: " + d1 + "\n" + "Grants: " + d0 + "\n" +
                            "WorkStudy" + d2 + "\n" + "------" + "\n" + "Total: " + d3,
                    "FAFSA Results", JOptionPane.INFORMATION_MESSAGE);
            passed = true;
            int passing = JOptionPane.showOptionDialog(null, "Would you like to complete another " +
                            "application" +
                            "?", "Continue",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
            if(passing == JOptionPane.YES_OPTION){
                passed = false;
            }
        }while(!passed);

    }
}
