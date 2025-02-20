public class Task {

    String Desciption;
    TaskType Type;
    Boolean Do;

    public Task(TaskType Type, String Desciption, Boolean Do) {
        this.Type = Type;
        this.Desciption = Desciption;
        this.Do = Do;
    } 

    public TaskType getType() {
        return Type;
    }

    public String getDescription() {
        return Desciption;
    }

    public Boolean getDo() {
        return Do;
    }

    public String toString() {
        return "\nType : " + Type + "\nDesciption : " + Desciption + "\nDo : " + Do;
    }

}