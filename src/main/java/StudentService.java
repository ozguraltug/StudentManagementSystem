import java.util.List;
import java.util.Scanner;

//3-Student ile ilgili methodlar icin StudentService classi olusturuldu
public class StudentService {


    // 9-reponun methodlarini kullnmak icin obje olustur
    Scanner inp=new Scanner(System.in);
    StudentRepository repository=new StudentRepository();

    //10-Tablo olusturmak icin method
    public void createTable(){
        repository.createTable();
    }

    //11-Öğrenci kaydetme
    public void saveStudent(){
        System.out.println("Ad : ");
        String name=inp.nextLine().trim();
        System.out.println("Soyad : ");
        String lastname=inp.nextLine().trim();
        System.out.println("Şehir : ");
        String city=inp.nextLine().trim();
        System.out.println("Yaş : ");
        int age=inp.nextInt();
        inp.nextLine();
        Student newStudent=new Student(name,lastname,city,age);
        repository.save(newStudent);

    }

    //13-tüm ğrencileri listele
    public void getAllStudents(){
        repository.findAll();
    }

    //15-Öğrenciyi silme
    public void deleteStudent(int id){
        repository.delete(id);
    }

    //17-id ile öğrenciyi getirme
    public Student getStudentById(int id){
       Student student= repository.findStudentById(id);
       return student;
    }

    //19-öğrenciyi güncelleme
    public void updateStudent(int id){
        Student student=getStudentById(id);
        if(student==null){
            System.out.println("Öğrenci bulunamadı!!!");
        }else{
            System.out.println("Ad : ");
            String name=inp.nextLine().trim();
            System.out.println("Soyad : ");
            String lastname=inp.nextLine().trim();
            System.out.println("Şehir : ");
            String city=inp.nextLine().trim();
            System.out.println("Yaş : ");
            int age=inp.nextInt();
            inp.nextLine();

            //yeni değerlerle fieldları güncelle
            student.setName(name);
            student.setLastname(lastname);
            student.setCity(city);
            student.setAge(age);
            repository.update(student);
        }
    }

    //21-girilen kelime ad veya soyad da var olan studentları listele
    //kelime ay--> ad veya soyad da ay içerenler gelecek
    public void listStudentsByNameOrLastName(){
        System.out.println("Ad veya soyad");
        String nameOrLastname=inp.nextLine();
        //birden fazla kayıt dönebilir
        List<Student> studentList=repository.findStudentByNameOrLastName(nameOrLastname);
        //listedeki öğrencileri yazdıralım
        //list boş ise
        if(studentList.size()==0){
            System.out.println("Öğrenci bulunamadı...");
        }else{
            studentList.forEach(System.out::println);
        }

    }




}
