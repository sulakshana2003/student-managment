package srcPackage;

public class StudentDetail implements avgMarks{
    private String name;
    private int age;
    private double[] subject;

    public StudentDetail(String name, int age, double[] subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSubject(double[] subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    @Override
    public double AvgMarks() {
        double avgmarks = 0;
        int count = 0;
        for (int i =0 ; i < subject.length; i++){
            avgmarks += subject[i];
            count++;
        }
        return avgmarks/count;
    }
    public void printDetails(){
        System.out.println("Name: "+ this.name);
        System.out.println("Age: "+this.age );
        for (int i = 0 ; i < subject.length; i++ ){
            String subjectName;
            switch (i){
                case 0 : subjectName = "Maths"; break;
                case 1 : subjectName = "It"; break;
                case 2 : subjectName = "Scinece"; break;
                default: subjectName = "default"; break;
            }
            System.out.println("Marks for "+subjectName+" : "+subject[i]);
        }
    }
}
