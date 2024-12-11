import java.util.Scanner;
public class bagian_b {
    
    // BAGIAN A
    static Scanner sc = new Scanner(System.in);
    static String mahasiswa[][] = new String[50][2];
    static String matkul[][][] = new String[50][50][3];
    static int totalSKS[] = new int[50];
    static int i = 0;

    static void tambahKrs() {
        
        boolean tambahMahasiswa = true;
        while (tambahMahasiswa) { 
            System.out.print("\nNama : ");
            mahasiswa[i][1] = sc.next();
            System.out.print("NIM : ");
            mahasiswa[i][0] = sc.next();

            int jumlahMatkul = 0;
            boolean tambahMataKuliah = true;
            while (tambahMataKuliah) { 
                System.out.print("Kode Mata Kuliah : ");
                matkul[i][jumlahMatkul][0] = sc.next();
                System.out.print("Nama Mata Kuliah : ");
                sc.nextLine();
                matkul[i][jumlahMatkul][1] = sc.nextLine();

                System.out.print("Jumlah SKS (1-3) : ");
                matkul[i][jumlahMatkul][2] = sc.next();
                if (matkul[i][jumlahMatkul][2].equals("1") || 
                    matkul[i][jumlahMatkul][2].equals("2") || 
                    matkul[i][jumlahMatkul][2].equals("3")) {
                    totalSKS[i] += Integer.parseInt(matkul[i][jumlahMatkul][2]);
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

            System.out.println("Total SKS yang diambil: " + totalSKS[i]);

            System.out.print("Tambah mahasiswa lain? (y/t): ");
            String lanjutMahasiswa = sc.next();
            if (lanjutMahasiswa.equalsIgnoreCase("t")) {
                tambahMahasiswa = false;
            } else {
                i++;
            }
        }
    }
    
    // BAGIAN B
    static void tampilkanKRS() {
        System.out.print("Masukkan NIM mahasiswa: ");
        String nim = sc.next();

        boolean ditemukan = false;
        for (int i = 0; i <= i; i++) {
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

    // BAGIAN C
    static void analisisDataKRS() {
        int jumlahKurang20 = 0;
        System.out.println("\nDaftar mahasiswa dengan SKS kurang dari 20:");
        for (int j = 0; j <= i; j++) {
            if (totalSKS[j] < 20) {
                System.out.println("- NIM: " + mahasiswa[i][0] + ", Nama: " + mahasiswa[i][1] + ", Total SKS: " + totalSKS[j]);
                jumlahKurang20++;
            }
        }
        System.out.println("Jumlah mahasiswa dengan SKS kurang dari 20: " + jumlahKurang20);
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
                    tampilkanKRS();
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