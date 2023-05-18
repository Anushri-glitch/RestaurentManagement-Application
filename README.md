# RestaurentManagement-Application
This Application Based On MySQL Database

##### :purple_square: Its an API Based Web Application
## :one: Frameworks and Languages Used -
    1. SpringBoot
    2. JAVA
    3. Postman
    4. SQL
    
## :two: Dependency Used
    1. Spring Web
    2. Spring Boot Dev Tools
    3. Lombok
    4. Spring Data JPA
    5. MySQL Driver
    6. Validation
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
## :three: Dataflow (Functions Used In)
### :purple_square: 1. Model - Model is used to Iniitialize the required attributes and create the accessable constructors and methods
#### :o: User.java
```java
@Table(name="tabl_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="studentId")
    private Integer StudentId;
    private String StudentName;
    private Integer age;
    private String phoneNumber;
    private String branch;
    private String department;

    @Embedded
    @Column(name="address")
    private Address address;
}

```
#### :o: Address.java
```java
@Data
public class Address {
    private String landMark;
    private String zipcode;
    private String district;
    private String state;
    private String country;
}
```
#### :o: Laptop.java
```java
@Table(name = "tbl_laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "laptop_id")
    private Integer laptopId;
    private String name;
    private String brand;
    private Integer price;

    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
```

#### :o: Course.java
```java
@Table(name = "tbl_course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "course_id")
    private Integer courseId;
    private String title;
    private String description;
    private String duration;

    @ManyToMany
    @JoinColumn(name = "student_id")
    List<Student> studentList = new ArrayList<>();
}
```

#### :o: Book.java
```java
@Table(name = "tbl_book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "book_id")
    private Integer bookId;
    private String title;
    private String author;
    private String description;
    private String price;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
```
##### To See Model
:white_check_mark: [Mapping-Model](https://github.com/Anushri-glitch/Student-Data/tree/master/src/main/java/com/Shrishti/StudentData/Model)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 2. Service - This Layer is used to write the logic of our CRUD operaions.
#### :o: StudentService.java
```java
@Service
public class StudentService {
    @Autowired
    IBookRepository bookRepository;
    
    @Autowired
    ILaptopRepository laptopRepository;
    
    @Autowired
    ICourseRepository courseRepository;

    @Autowired
    IStudentRepository studRepository;

    public String saveStudent(Student student) {
        studRepository.save(student);
        return student.getStudentName();
    }
}
```

#### :o: LaptopService.java
```java
@Service
public class LaptopService {
    @Autowired
    IStudentRepository StudentRepository;
    @Autowired
    ILaptopRepository laptopRepository;
    public String saveLaptop(Laptop laptop, Integer studentId) {
        String response = null;
        if(StudentRepository.existsById(studentId)) {
            --------
            --------
            laptop.setStudent(student);
            laptopRepository.save(laptop);
            response = laptop.getName();
        }
        return response;
    }
}
```

#### :o: CourseService.java
```java
@Service
public class CourseService {

    @Autowired
    ICourseRepository courseRepository;

    public String saveCourse(Course course) {
        courseRepository.save(course);
        StringBuilder names = new StringBuilder();
        List<Student> studentList = course.getStudentList();
        for (Student student : studentList) names.append(student.getStudentName()).append(", ");
        return course.getTitle() + " having students " + names;
    }
}
```

#### :o: BookService.java
```java
@Service
public class BookService {
    @Autowired
    IStudentRepository StudentRepository;
    @Autowired
    IBookRepository repository;
    public void saveBook(Book book, Integer studentId) {
        if(StudentRepository.existsById(studentId)){
            Student student = StudentRepository.findById(studentId).get();
            book.setStudent(student);
            repository.save(book);
        }
    }
}
```

#### To See Service
:white_check_mark: [Mapping-Service](https://github.com/Anushri-glitch/Student-Data/tree/master/src/main/java/com/Shrishti/StudentData/Service)
----------------------------------------------------------------------------------------------------------------------------------------------------

### :purple_square: 3. Controller - This Controller is used to like UI between Model and Service and also for CRUD Mappings.
#### :o: StudentController.java
```java
@RestController
@RequestMapping("/studentMod")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("student")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        String response = studentService.saveStudent(student);
        return new ResponseEntity<>("Student name " + response + "saved!" , HttpStatus.CREATED);
    }
}
```

#### :o: LaptopController.java
```java
@RestController
@RequestMapping("/laptopMod")
public class LaptopController {
    @Autowired
    LaptopService laptopService;
    @PostMapping("saveLaptop")
    private ResponseEntity<String> saveLaptop(@RequestBody Laptop laptop, @RequestParam Integer studentId){
        String response = laptopService.saveLaptop(laptop, studentId);
        if(response != null){
            if(response.equals("")) return new ResponseEntity<>("Student doesn't exist", HttpStatus.BAD_REQUEST);
            else return new ResponseEntity<>(response + "Laptop saved!", HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>("Laptop already exist ", HttpStatus.BAD_REQUEST);
    }
}
```

#### :o: CourseController.java
```java
@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    @Autowired
    CourseService service;
    @Autowired
    Util util;
    @PostMapping("saveCourse")
    private ResponseEntity<String> saveCourse(@RequestBody String courseStr) throws JSONException {
        Course courseObj = util.StringJsonToCourse(courseStr);
        String response = service.saveCourse(courseObj);
        return new ResponseEntity<>("Course with name " + response + "saved!", HttpStatus.CREATED);
    }
}
```

#### :o: BookController.java
```java
@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("saveBook")
    private ResponseEntity<String> saveBook(@RequestBody Book book, @RequestParam Integer studentId){
        bookService.saveBook(book, studentId);
        return new ResponseEntity<>("Book saved!", HttpStatus.CREATED);
    }
}
```

#### To See Controller
:white_check_mark: [Mapping-Controller](https://github.com/Anushri-glitch/Student-Data/tree/master/src/main/java/com/Shrishti/StudentData/Controller)
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
### :purple_square: 3. Repository : data access object (DAO) is an object that provides an abstract interface to some type of database or other persistence mechanisms.
#### :o: IStudentRepository.java
```java
@Repository
public interface IStudentRepository extends JpaRepository<User,Integer> {
}
```

#### :o: ILaptopRepository.java
```java
@Repository
public interface ILaptopRepository extends JpaRepository<Post,Integer> {
}
```

#### :o: ICourseRepository.java
```java
@Repository
public interface ICourseRepository extends JpaRepository<AuthenticationToken,Long> {
}
```

#### :o: IBookRepository.java
```java
@Repository
public interface IBookRepository extends JpaRepository<AuthenticationToken,Long> {
}
```

#### To See Repository
:white_check_mark: [Mapping-DAO](https://github.com/Anushri-glitch/Student-Data/tree/master/src/main/java/com/Shrishti/StudentData/Dao)
-------------------------------------------------------------------------------------------------------------------------------------------------------

## :four: DataStructures Used in Project
    1. ResponseEntity
    2. List
    3. JsonArray
    4. JsonObject
-------------------------------------------------------------------------------------------------------------------------------------------------------
## :five: DataBase Response In project

:arrow_right: Student table
 ```sql
 select * from tabl_student;
+------------+--------------------+---------+-----------+-----------+---------------+---------+------+----------+---------------+--------------+
| student_id | student_name       | country | district  | land_mark | state         | zipcode | age  | branch   | department    | phone_number |
+------------+--------------------+---------+-----------+-----------+---------------+---------+------+----------+---------------+--------------+
|          2 | Anushka Srivastava | NULL    | Prayagraj | NULL      | Uttar Pradesh | 211019  |   25 | Computer | CS Engeenring | 1234567890   |
+------------+--------------------+---------+-----------+-----------+---------------+---------+------+----------+---------------+--------------+
```
:arrow_right: Laptop Table 
```sql
 select * from tbl_laptop;
+-----------+---------+---------------------+-------+------------+
| laptop_id | brand   | name                | price | student_id |
+-----------+---------+---------------------+-------+------------+
|         1 | Samsung | Samsung Galaxy Book |  NULL |          2 |
|         3 | Dell    | Dell Inspiron       |  NULL |          3 |
+-----------+---------+---------------------+-------+------------+
```

:arrow_right: Course Table 

```sql
 select * from table_post;
+---------+-------------------------+-----------+-------------+---------+--------------------------------------------------+
| post_id | created_date            | post_date | update_date | user_id | post_data                                        |
+---------+-------------------------+-----------+-------------+---------+--------------------------------------------------+
|       6 | 2023-03-16 13:17:16.725 | NULL      | NULL        |       1 | this is essential data which is hiding by admin. |
|       7 | 2023-03-16 13:18:29.099 | NULL      | NULL        |       1 | this is essential data which is hiding by admin. |
|       8 | 2023-03-16 13:32:40.327 | NULL      | NULL        |       2 | Life is Essential                                |
|       3 | 2023-05-16 12:45:41.418 | NULL      | NULL        |       1 | I Am The Best!!!                                 |
+---------+-------------------------+-----------+-------------+---------+--------------------------------------------------+
```
:arrow_right: AuthenticationToken Table 

```sql
 select * from authentication_token;
+----------+--------------------------------------+---------------------+------------+
| token_id | token                                | token_creation_date | fk_user_id |
+----------+--------------------------------------+---------------------+------------+
|        1 | 98e04d49-6aff-46f5-8020-6fe24a652ec9 | 2023-05-15          |         52 |
+----------+--------------------------------------+---------------------+------------+
```
----------------------------------------------------------------------------------------------------------------------------------------------------------

## :six: Generated API's

:white_check_mark: SAVE STUDENT - http://localhost:8081/studentMod/student

:white_check_mark: GET STUDENT - http://localhost:8081/studentMod/studentA

:white_check_mark: GET STUDENT BY ID - http://localhost:8081/studentMod/student

:white_check_mark: UPDATE STUDENT - http://localhost:8081/studentMod/student

:white_check_mark: DELETE STUDENT - http://localhost:8081/studentMod/student

:white_check_mark: SAVE LAPTOP - http://localhost:8081/laptopMod/saveLaptop

:white_check_mark: GET LAPTOP BY ID - http://localhost:8081/laptopMod/getLaptop?laptopId={id}&studentId={id}

:white_check_mark: UPDATE LAPTOP - http://localhost:8081/laptopMod/getLaptop?laptopId={id}

:white_check_mark: DELETE LAPTOP - http://localhost:8081/laptopMod/getLaptop?laptopId={id}

:white_check_mark: SAVE COURSE - http://localhost:8081/course/saveCourse

:white_check_mark: GET COURSE - http://localhost:8081/course/getCourse?studentId={id}&courseId={id}

:white_check_mark: UPDATE COURSE - http://localhost:8081/course/updateCourse?courseId={id}

:white_check_mark: DELETE COURSE - http://localhost:8081/course/deleteCourse?courseId={id}

:white_check_mark: SAVE BOOK -  http://localhost:8081/book/saveBook

:white_check_mark: GET BOOK -  http://localhost:8081/book/getBook?studentId={id}&bookId={id}

:white_check_mark: UPDATE BOOK -  http://localhost:8081/book/updateBook?bookId={id}

:white_check_mark: DELETE BOOK -  http://localhost:8081/book/deleteBook?bookId={id}

---------------------------------------------------------------------------------------------------------------------------------------------------------

## :seven: Project Result
### :o: Student Response

![Screenshot (805)](https://github.com/Anushri-glitch/Student-Data/assets/47708011/0a2227a0-f57b-4496-ab8b-8535701d053b)
![Screenshot (806)](https://github.com/Anushri-glitch/Student-Data/assets/47708011/298f2e20-90ec-4706-9061-f08fd61c5c67)
![Screenshot (807)](https://github.com/Anushri-glitch/Student-Data/assets/47708011/87c32bfa-f332-428f-aee2-0826c7d2e06a)
![Screenshot (808)](https://github.com/Anushri-glitch/Student-Data/assets/47708011/c705a5dc-5941-4948-906b-5fcb2cfc3de5)

### :o: Laptop Response

![Screenshot (809)](https://github.com/Anushri-glitch/Student-Data/assets/47708011/52ea3c0b-c172-4f2d-9668-6bde7dd3616f)
![Screenshot (810)](https://github.com/Anushri-glitch/Student-Data/assets/47708011/d0b50a30-d41b-459c-aee3-deca9f985024)
![Screenshot (811)](https://github.com/Anushri-glitch/Student-Data/assets/47708011/4536725f-e8d6-439a-83ea-0236e8f815b6)
![Screenshot (812)](https://github.com/Anushri-glitch/Student-Data/assets/47708011/8e2fcf36-0339-48ea-9f41-df0069a7da54)




----------------------------------------------------------------------------------------------------------------------------------------------------------



