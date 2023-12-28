import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    private String[][] mayinlar; // Mayınları tutmak için matris
    private String[][] gosterilenHarita; // Oyuncuya gösterilen oyun alanı matrisi
    private int toplamMayin; // Toplam mayın sayısı

    // Kurucu metot
    public MineSweeper() {
        this.mayinlar = null;
        this.gosterilenHarita = null;
        this.toplamMayin = 0;
    }

    // Oyunu başlatan metot
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Mayın tarlasının satır sayısını girin: ");
            int satirSayisi = scanner.nextInt();

            System.out.print("Mayın tarlasının sütun sayısını girin: ");
            int sutunSayisi = scanner.nextInt();

            if (satirSayisi < 2 || sutunSayisi < 2) {
                System.out.println("Hatalı giriş! Satır ve sütun sayıları en az 2 olmalıdır.");
                continue;
            }

            mayinlariOlustur(satirSayisi, sutunSayisi);

            mayinlariYerlestir((satirSayisi * sutunSayisi) / 4);

            gosterilenHaritayiOlustur(satirSayisi, sutunSayisi);
            System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !");

            oyunuOyna(satirSayisi, sutunSayisi);

            gosterilenHaritayiGoster();

            System.out.print("Yeniden oynamak istiyor musunuz? (Evet için 'e' veya 'E', Hayır için herhangi bir tuş): ");
            char cevap = scanner.next().charAt(0);

            if (cevap != 'e' && cevap != 'E') {
                break;
            }
        }

        System.out.println("Oyunu kapattınız. İyi günler!");
    }

    // Mayınları tutacak matrisi oluşturan metot
    private void mayinlariOlustur(int satirSayisi, int sutunSayisi) {
        mayinlar = new String[satirSayisi][sutunSayisi];
        toplamMayin = 0;

        // Matrisi "0" değerleriyle başlat
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                mayinlar[i][j] = "0";
            }
        }
    }

    // Oyuncuya gösterilen oyun tahtasını oluşturan metot
    private void gosterilenHaritayiOlustur(int satirSayisi, int sutunSayisi) {
        gosterilenHarita = new String[satirSayisi][sutunSayisi];

        // Matrisi "-" değerleriyle başlat
        for (int i = 0; i < satirSayisi; i++) {
            for (int j = 0; j < sutunSayisi; j++) {
                gosterilenHarita[i][j] = "-";
            }
        }
    }

    // Oyunu başlatan metot
    private void oyunuOyna(int satirSayisi, int sutunSayisi) {
        Scanner input = new Scanner(System.in);
        boolean oyunDevamEdiyor = true;

        while (oyunDevamEdiyor) {
            gosterilenHaritayiGoster();

            System.out.print("Satırı Giriniz: ");
            int satir = input.nextInt();

            System.out.print("Sütunu giriniz: ");
            int sutun = input.nextInt();

            if (!gecerliHamle(satir, sutun, satirSayisi, sutunSayisi)) {
                System.out.println("Geçersiz koordinat! Lütfen sınırlar içinde bir koordinat giriniz.");
                continue;
            }

            if (mayinlar[satir][sutun].equals("*")) {
                System.out.println("===================");
                System.out.println("Oyunu kaybettiniz!");
                oyunDevamEdiyor = false;
            } else {
                int mayinSayisi = 0;

                // Çevredeki hücreleri kontrol et ve mayın sayısını hesapla
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int yeniSatir = satir + i;
                        int yeniSutun = sutun + j;

                        if (gecerliHamle(yeniSatir, yeniSutun, satirSayisi, sutunSayisi)) {
                            if (mayinlar[yeniSatir][yeniSutun].equals("*")) {
                                mayinSayisi++;
                            }
                        }
                    }
                }

                // Gösterilen haritadaki ilgili hücreyi güncelle ve toplam mayın sayısını artır
                gosterilenHarita[satir][sutun] = String.valueOf(mayinSayisi);
                toplamMayin++;

                // Oyunu kazanıp kazanmadığını kontrol et
                if (toplamMayin == (satirSayisi * sutunSayisi) - (satirSayisi * sutunSayisi) / 4) {
                    System.out.println("===================");
                    System.out.println("Tebrikler! Oyunu kazandınız!");
                    oyunDevamEdiyor = false;
                }
            }
        }

        oyunSonuDurumu();
    }

    // Oyuncuya gösterilen haritayı ekrana yazdıran metot
    private void gosterilenHaritayiGoster() {
        System.out.println("===================");
        for (String[] satir : gosterilenHarita) {
            for (String hucre : satir) {
                System.out.print(hucre + " ");
            }
            System.out.println();
        }
        System.out.println("===================");
    }

    // Geçerli bir hamle olup olmadığını kontrol eden metot
    private boolean gecerliHamle(int satir, int sutun, int satirSayisi, int sutunSayisi) {
        return satir >= 0 && satir < satirSayisi && sutun >= 0 && sutun < sutunSayisi && gosterilenHarita[satir][sutun].equals("-");
    }

    // Mayınları rastgele yerleştiren metot
    private void mayinlariYerlestir(int mayinSayisi) {
        Random random = new Random();

        int satirSayisi = mayinlar.length;
        int sutunSayisi = mayinlar[0].length;

        for (int i = 0; i < mayinSayisi; i++) {
            int satir = random.nextInt(satirSayisi);
            int sutun = random.nextInt(sutunSayisi);

            // Bir hücrede zaten mayın varsa, farklı bir hücre seç
            while (mayinlar[satir][sutun].equals("*")) {
                satir = random.nextInt(satirSayisi);
                sutun = random.nextInt(sutunSayisi);
            }

            mayinlar[satir][sutun] = "*";
        }
    }

    // Oyunun son durumunu gösteren metot
    private void oyunSonuDurumu() {
        // Oyunun sonunda haritayı güncelle, tüm mayınları göster
        for (int i = 0; i < mayinlar.length; i++) {
            for (int j = 0; j < mayinlar[0].length; j++) {
                if (mayinlar[i][j].equals("*")) {
                    gosterilenHarita[i][j] = "*"; // Mayını göster
                } else if (!gosterilenHarita[i][j].equals("F")) { // Henüz işaretlenmemiş ve açılmamış bir hücreye "-"
                    gosterilenHarita[i][j] = "-";
                }
            }
        }
    }
}
