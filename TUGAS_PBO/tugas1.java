import java.util.Scanner;

public class tugas1 {
    public static void main(String[] args) {
        String nimAkhir = "010";
        String validUsername = "Admin" + nimAkhir;
        String validPassword = "password" + nimAkhir; // sha256 when

        String validNama = "Ken Aryo Bimantoro";
        String validNim = "202310370311006";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan Password: ");
                String password = scanner.nextLine();

                if (username == validUsername && password == validPassword) {
                    System.out.println("Login Admin berhasil!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
                break;
            case 2:
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();

                if (nama == validNama && nim == validNim) {
                    System.out.println("Login Mahasiswa berhasil!");
                    System.out.printf("Nama: %s\nNIM: %s\n", nama, nim);
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}
