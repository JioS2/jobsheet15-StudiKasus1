import java.util.Scanner;
public class bagian_b {
    
    // BAGIAN A
    static Scanner sc = new Scanner(System.in);
    static String mahasiswa[][] = new String[50][2];
    static String matkul[][][] = new String[50][50][3];
    static int totalSKS[] = new int[50];
    static int jumlahMahasiswa = 0;

    static void tambahKrs() {
        
        boolean tambahMahasiswa = true;
        while (tambahMahasiswa) { 
            System.out.print("\nNama : ");
            mahasiswa[jumlahMahasiswa][1] = sc.next();
            System.out.print("NIM : ");
            mahasiswa[jumlahMahasiswa][0] = sc.next();

            int jumlahMatkul = 0;
            boolean tambahMataKuliah = true;
            while (tambahMataKuliah) { 
                System.out.print("Kode Mata Kuliah : ");
                matkul[jumlahMahasiswa][jumlahMatkul][0] = sc.next();
                System.out.print("Nama Mata Kuliah : ");
                sc.nextLine();
                matkul[jumlahMahasiswa][jumlahMatkul][1] = sc.nextLine();

                System.out.print("Jumlah SKS (1-3) : ");
                matkul[jumlahMahasiswa][jumlahMatkul][2] = sc.next();
                if (matkul[jumlahMahasiswa][jumlahMatkul][2].equals("1") || 
                    matkul[jumlahMahasiswa][jumlahMatkul][2].equals("2") || 
                    matkul[jumlahMahasiswa][jumlahMatkul][2].equals("3")) {
                    totalSKS[jumlahMahasiswa] += Integer.parseInt(matkul[jumlahMahasiswa][jumlahMatkul][2]);
                    System.out.println("Data Mata Kuliah berhasil ditambahkan!");
                } else {
                    System.out.println("Jumlah SKS tidak valid!");
                    continue;
                }

                System.out.print("\nTambah mata kuliah lagi? (y/t): ");
                String lanjutMataKuliah = sc.next();
                if (lanjutMataKuliah.equalsIgnoreCase("t")) {
                    tambahMataKuliah = false;
                }
            }

            System.out.println("Total SKS yang diambil: " + totalSKS[jumlahMahasiswa]);

            System.out.print("Tambah mahasiswa lain? (y/t): ");
            String lanjutMahasiswa = sc.next();
            if (lanjutMahasiswa.equalsIgnoreCase("t")) {
                tambahMahasiswa = false;
            } else {
                jumlahMahasiswa++;
            }
        }
    }
    
    // BAGIAN B
    static void tampilkanKRS() {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = sc.next();

        boolean ditemukan = false;
        for (int i = 0; i <= jumlahMahasiswa; i++) {
            if (mahasiswa[i][0] != null && mahasiswa[i][0].equals(nim)) {
                ditemukan = true;
                System.out.println("Daftar KRS untuk NIM " + nim + " (" + mahasiswa[i][1] + "):");
                for (int j = 0; matkul[i][j][0] != null; j++) {
                    System.out.println("- Kode: " + matkul[i][j][0] +
                            ", Nama: " + matkul[i][j][1] +
                            ", SKS: " + matkul[i][j][2]);
                }
                System.out.println("Total SKS: " + totalSKS[i]);
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Data KRS untuk NIM " + nim + " tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Pemantauan KRS Mahasiswa ===");
            System.out.println("1. Tambah Data KRS");
            System.out.println("2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("3. Analisis Data KRS");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu : ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    tambahKrs();
                    break;
                case 2:
                    tampilkanKRS();
                    break;
            }
        }
    }
}