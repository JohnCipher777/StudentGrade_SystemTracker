public class GradeSystemTracker {
    private final String[] studentNames;
    private final double[][] studentGrades;
    private final String[][] subjectNames;
    private final int numStudents;
    private final int numSubjects;
    private boolean deletion_detected;
    private boolean noremaining_data;

    public GradeSystemTracker(int numStudents, int numSubjects) {
        this.numStudents = numStudents;
        this.numSubjects = numSubjects;
        studentNames = new String[numStudents];
        studentGrades = new double[numStudents][numSubjects];
        subjectNames = new String[numStudents][numSubjects];
    }

    public void addStudent(String name, double[] grades, String[] subjects) {
        for (int i = 0; i < numStudents; i++) {
            if (studentNames[i] == null) {
                studentNames[i] = name;
                studentGrades[i] = grades;
                subjectNames[i] = subjects;
                return;
            }
        }
        System.out.println("Maximum number of students reached. Cannot add more students.");
    }
   
    public String getStudentName(int index) {
        return studentNames[index];
    }

    public double[] getStudentGrades(int index) {
        return studentGrades[index];
    }

    public String[] getSubjectNames(int index) {
        return subjectNames[index];
    }

    public double getAverageGrade(int index) {
        double[] grades = studentGrades[index];
        double sum = 0.0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public int getNumSubjects() {
        return numSubjects;
    }
    public void deleteStudent(String name) {
        int index = -1;
        for (int i = 0; i < numStudents; i++) {
            if (studentNames[i] != null && studentNames[i].equals(name)) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            studentNames[index] = null;
            studentGrades[index] = null;
            //System.out.println("[SUCCESS]: Student " + name + " has been deleted.");
            deletion_detected = true;
        } else {
           // System.out.println("[FAILED]: Student " + name + " not found.");
            deletion_detected = false;
        }
    }
    public boolean deletion_detected(){
        return this.deletion_detected;
    }
    public void setRemainingdata_condition(boolean noremaining_data){
        this.noremaining_data = noremaining_data;
    }
    public boolean noreemaining_data(){
        return this.noremaining_data;
    }
}
