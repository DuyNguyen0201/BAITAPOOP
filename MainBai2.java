interface EmailSender {
    void sendEmail();
}

interface Programmer {
    void code();
}

interface Salesperson {
    void sell();
}

class OfficeEmployee implements EmailSender {
    private String name;

    public OfficeEmployee(String name) {
        this.name = name;
    }

    @Override
    public void sendEmail() {
        System.out.println(name + " dang gui email.");
    }
}

class TechnicalEmployee implements EmailSender, Programmer {
    private String name;

    public TechnicalEmployee(String name) {
        this.name = name;
    }

    @Override
    public void sendEmail() {
        System.out.println(name + " dang gui email.");
    }

    @Override
    public void code() {
        System.out.println(name + " dang lap trinh.");
    }
}

class SalesEmployee implements EmailSender, Salesperson {
    private String name;

    public SalesEmployee(String name) {
        this.name = name;
    }

    @Override
    public void sendEmail() {
        System.out.println(name + " dang gui email.");
    }

    @Override
    public void sell() {
        System.out.println(name + " dang ban hang.");
    }
}

public class MainBai2 {
    public static void main(String[] args) {
        OfficeEmployee officeEmp = new OfficeEmployee("Nhan vien Van phong");
        TechnicalEmployee techEmp = new TechnicalEmployee("Nhan vien Ky thuat");
        SalesEmployee salesEmp = new SalesEmployee("Nhan vien Ban hang");

        officeEmp.sendEmail();

        techEmp.code();
        techEmp.sendEmail();

        salesEmp.sell();
        salesEmp.sendEmail();
    }
}