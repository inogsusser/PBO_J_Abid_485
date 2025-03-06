import java.util.Scanner;
import java.time.LocalDate;

public class Modul_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Meminta input dari pengguna
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        
        System.out.print("Masukkan Jenis Kelamin (L/P): ");
        char jenisKelaminInput = Character.toLowerCase(scanner.next().charAt(0));
        
        System.out.print("Masukkan Tahun Lahir: ");
        int tahunLahir = scanner.nextInt();
        
        // Menutup scanner
        scanner.close();
        
        // Mendapatkan tahun saat ini
        int tahunSekarang = LocalDate.now().getYear();
        int umur = tahunSekarang - tahunLahir;
        
        // Menentukan jenis kelamin
        String jenisKelamin = switch (jenisKelaminInput) {
            case 'l' -> "Laki-laki";
            case 'p' -> "Perempuan";
            default -> "Tidak Diketahui";
        };
        
        // Menampilkan output dengan string block dan format
        String output = """
            ===== Data Diri =====
            Nama: %s
            Jenis Kelamin: %s
            Umur: %d tahun
            """.formatted(nama, jenisKelamin, umur);
        
        System.out.println(output);
    }
}
