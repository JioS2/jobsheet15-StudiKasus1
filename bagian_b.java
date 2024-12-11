import java.util.Scanner;
public class bagian_b {
    
    // BAGIAN A
    static Scanner sc = new Scanner(System.in);
    static String mahasiswa[][] = new String[50][2];
    static String matkul[][] = new String[50][3];
    static int totalSKS[] = new int[50];
    static int in = 0;

    static void tambahKrs() {
        boolean tambahMahasiswa = true;
        while (tambahMahasiswa) { 
            System.out.print("\nNama : ");
            mahasiswa[in][1] = sc.next();
            System.out.print("NIM : ");
            mahasiswa[in][0] = sc.next();
            System.out.println("--------------------");
    
            int jumlahMatkul = 0; 
            boolean tambahMataKuliah = true;
            while (tambahMataKuliah) { 
                System.out.print("\nKode Mata Kuliah : ");
                matkul[jumlahMatkul][0] = sc.next();
                System.out.print("Nama Mata Kuliah : ");
                sc.nextLine();
                matkul[jumlahMatkul][1] = sc.nextLine();
    
                System.out.print("Jumlah SKS (1-3) : ");
                matkul[jumlahMatkul][2] = sc.next();
                if (matkul[jumlahMatkul][2].equals("1") || 
                    matkul[jumlahMatkul][2].equals("2") || 
                    matkul[jumlahMatkul][2].equals("3")) {
                    totalSKS[in] += Integer.parseInt(matkul[jumlahMatkul][2]);
                    System.out.println("Data Mata Kuliah berhasil ditambahkan!");
                    jumlahMatkul++; 
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
    
            System.out.println("Total SKS yang diambil: " + totalSKS[in]);
    
            System.out.print("Tambah mahasiswa lain? (y/t): ");
            String lanjutMahasiswa = sc.next();
            if (lanjutMahasiswa.equalsIgnoreCase("t")) {
                tambahMahasiswa = false;
            } else {
                in++;
            }
        }
    }
    
    // BAGIAN B
    static void menampilkanKRS() {
        System.out.print("\nMasukkan NIM mahasiswa: ");
        String nim = sc.next();

        boolean ditemukan = false;
        for (int i = 0; i <= i; i++) {
            if (mahasiswa[in][0].equals(nim)) {
                ditemukan = true;
                System.out.println("\nDaftar KRS untuk NIM " + nim + " (" + mahasiswa[i][1] + "):");
                System.out.printf("%-15s%-20s%-5s\n", "Kode:", "Nama:", "SKS:");
                for (int j = 0; matkul[j][0] != null; j++) {
                    System.out.printf("%-15s%-20s%-5s\n", matkul[j][0], matkul[j][1], matkul[j][2]);
                }
                System.out.println("\nTotal SKS: " + totalSKS[i]);
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("\nData KRS untuk NIM " + nim + " tidak ditemukan.");
            return;
        }
    }

    // BAGIAN C
    static void analisisDataKRS() {
        int jumlahKurang20 = 0;
        System.out.println("\nDaftar mahasiswa dengan SKS kurang dari 20:");
        for (int j = 0; j <= in; j++) {
            if (totalSKS[j] < 20) {
                System.out.println("- NIM: " + mahasiswa[in][0] + ", Nama: " + mahasiswa[in][1] + ", Total SKS: " + totalSKS[j]);
                jumlahKurang20++;
            }
        }
        System.out.println("\nJumlah mahasiswa dengan SKS kurang dari 20: " + jumlahKurang20);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Sistem Pemantauan KRS Mahasiswa =====");
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
                    menampilkanKRS();
                    break;
                case 3:
                    analisisDataKRS();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}