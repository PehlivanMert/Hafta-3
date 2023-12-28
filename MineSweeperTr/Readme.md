# MineSweeper Oyunu - README

Bu proje Mayın Tarlası oyununu içermektedir. Oyun, kullanıcıdan oyun tahtasının boyutlarını alır, mayınları rastgele yerleştirir ve ardından oyuncunun hamlelerini kabul eder. Oyun devam ettikçe, oyuncu hücreleri açar ve oyunun sonunda kazanıp kazanmadığını kontrol eder. 🎮

## Class: MineSweeper

### Fields
- `mayinlar`: Mayınları tutmak için bir matris.
- `gosterilenHarita`: Oyuncuya gösterilen oyun tahtası matrisi.
- `toplamMayin`: Toplam mayın sayısı.

### Constructor
- `public MineSweeper()`: Kurucu metot, sınıfın örneklerini başlatır ve başlangıç değerlerini atar.

### Methods
- `public void run()`: Oyunu başlatan metot. Kullanıcıdan oyun tahtası boyutlarını alır. Mayınları oluşturur, yerleştirir ve oyun tahtasını başlatır. Oyuncunun hamlelerini kabul eder ve oyunun durumunu kontrol eder. Oyun bittiğinde kullanıcıya tekrar oynamak isteyip istemediğini sorar.

- `private void mayinlariOlustur(int satirSayisi, int sutunSayisi)`: Mayınları tutacak matrisi oluşturan metot. Belirtilen boyutlarda bir matris oluşturur ve tüm hücreleri "0" ile başlatır.

- `private void gosterilenHaritayiOlustur(int satirSayisi, int sutunSayisi)`: Oyuncuya gösterilen oyun tahtasını oluşturan metot. Belirtilen boyutlarda bir matris oluşturur ve tüm hücreleri "-" ile başlatır.

- `private void oyunuOyna(int satirSayisi, int sutunSayisi)`: Oyunu başlatan metot. Oyuncunun hamlelerini kabul eder, hücreleri açar ve oyunun durumunu kontrol eder.

- `private void gosterilenHaritayiGoster()`: Oyuncuya gösterilen haritayı ekrana yazdıran metot.

- `private boolean gecerliHamle(int satir, int sutun, int satirSayisi, int sutunSayisi)`: Geçerli bir hamle olup olmadığını kontrol eden metot.

- `private void mayinlariYerlestir(int mayinSayisi)`: Mayınları rastgele yerleştiren metot.

- `private void oyunSonuDurumu()`: Oyunun son durumunu gösteren metot. Oyunun sonunda haritayı günceller, tüm mayınları gösterir.
