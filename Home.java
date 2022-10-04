import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

class Person {

    private int id;
    private String name;
    private int age;
    private String job;

    Person(int id, String name, int age, String job) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String toString() {
        return id + " " + name + " " + job + " " + age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

class Home {

    public static void main(String[] args) {

        List<Person> c = new ArrayList<Person>();
        // Person p = new Person();

        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1.INSERT:");
            System.out.println("2.DISPLAY");
            System.out.println("3. SEARCH");
            System.out.println("4. UPDATE");
            System.out.println("Your Choice:");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Id Number:");
                    int id = s.nextInt();
                    System.out.println("Name:");
                    String name = s1.nextLine();
                    System.out.println("Age");
                    int age = s.nextInt();
                    System.out.println("Job");
                    String job = s1.nextLine();
                    c.add(new Person(id, name, age, job));

                    break;
                case 2:
                    System.out.println("-----------------------------------------------------");
                    Iterator<Person> i = c.iterator();

                    while (i.hasNext()) {
                        Person p = i.next();
                        System.out.println(p);
                    }
                    System.out.println("-----------------------------------------------------");
                    break;
                case 3:
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Enter Id to Search");
                    boolean found = false;
                    int id_num = s.nextInt();
                    i = c.iterator();
                    while (i.hasNext()) {
                        Person p = i.next();
                        if (p.getId() == id_num) {
                            System.out.println(p);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Record does not exists!");
                    }
                    System.out.println("-----------------------------------------------------");
                    break;
                case 4:
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Enter Id to DELETE");
                    found = false;
                    id_num = s.nextInt();
                    i = c.iterator();
                    while (i.hasNext()) {
                        Person p = i.next();
                        if (p.getId() == id_num) {
                            i.remove();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Record does not exists!");
                    } else {
                        System.out.println("Deleted Successfully!");
                    }
                    System.out.println("-----------------------------------------------------");
                    break;

                case 5:
                    System.out.println("-----------------------------------------------------");
                    System.out.println("Enter Id to UPDATE");
                    found = false;
                    id_num = s.nextInt();
                    ListIterator<Person> pi = c.listIterator();
                    while (pi.hasNext()) {
                        Person p = pi.next();
                        if (p.getId() == id_num) {
                            System.out.println("Enter new name:");
                            name = s1.nextLine();
                            System.out.println("Enter new age:");
                            age = s.nextInt();
                            System.out.println("Enter new job:");
                            job = s1.nextLine();

                            pi.set(new Person(id_num, name, age, job));
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Record does not exists!");
                    } else {
                        System.out.println("Update Successfully!");
                    }
                    System.out.println("-----------------------------------------------------");
                    break;
            }
        } while (ch != 0);
    }
}