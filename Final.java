import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Final {
    public static void displaystudent(String[] student, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(student[i]);
        }
    }
    public static String [] UpdateStudent(String [] student,int n){
        System.out.print("moi ban nhap vi tri muon tim:");
        Scanner sc = new Scanner(System.in);
        int index=sc.nextInt();
        if(index>n){
            System.out.println("khong co trong danh sach");
            return student;
        }
        int flag=-1;
        for (int i = 0; i <n ; i++) {
            if(student[i].equals(student[index])){
                flag=i;
            }
        }
        if(flag==-1){
            System.out.println("khong co trong danh sach");
            return student;
        }
        sc.nextLine();
        String regex = "^B\\d{7}";
        System.out.print("Moi ban nhap Ma sinh vien muon sua:");
        String newstudent = sc.nextLine();
        while (!newstudent.matches(regex)) {
            System.out.print("Moi ban nhap lai Ma sinh vien:");
            newstudent = sc.nextLine().trim();
        }
        student[flag] = newstudent;
        return student;
    }
    public static int addstudent(String[] student, int n) {
        String regex = "^B\\d{7}";
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap Ma sinh vien:");
        String newstudent = sc.nextLine();
        while (!newstudent.matches(regex)) {
            System.out.print("Moi ban nhap lai Ma sinh vien:");
            newstudent = sc.nextLine().trim();
        }
        student[n] = newstudent;
        return n + 1;
    }
    public static int deleteStudent(String[] student, int n){
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap Ma sinh vien:");
        String newstudent = sc.nextLine();
        int flag=-1;
        for (int i = 0; i < n; i++) {
            if(student[i].equals(newstudent)){
                flag=i;
            }
        }
        if(flag==-1){
            System.out.println("khong co trong danh sach");
            return n;
        }
        for (int i = flag; i <n-1 ; i++) {
            student[i]=student[i+1];
        }
        return n-1;
    }
    public static void search(String [] student,int n){
        Scanner sc = new Scanner(System.in);
        System.out.print("Moi ban nhap Ma sinh vien:");
        String newstudent = sc.nextLine();
        String regex = ".*" + Pattern.quote(newstudent) + ".*";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        System.out.println("Các MSSV phù hợp:");
        boolean found = false;

        for (String mssv : student) {
            Matcher matcher = pattern.matcher(mssv);
            if (matcher.matches()) {
                System.out.println(mssv);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy MSSV nào.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        String[] student = new String[100];
        int n = 0;
        do {
            System.out.println("\n========== MENU CHINH ==========");
            System.out.println("1. Hiển thị");
            System.out.println("2. Thêm mới (Có Regex)");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. search");
            System.out.println("0. Thoat");
            System.out.println("================================");
            System.out.print("Chon chuc nang: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    displaystudent(student,n);
                    break;
                case "2":
                    n = addstudent(student, n);
                    break;
                case "3":
                    student=UpdateStudent(student,n);
                    break;
                case "4":
                    n=deleteStudent(student,n);
                    break;
                case "5":
                    search(student,n);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("khong hop le");
                    break;
            }
        } while (choice != "0");
        sc.close();
    }
}