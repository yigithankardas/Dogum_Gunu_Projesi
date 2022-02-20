# Nasıl indirilir?
Sitenin sağındaki `releases` kısmına tıklayıp `Assets`'e basarak `Dogum_Gunleri.jar` dosyasını indirip çift-tık ile çalıştırın.

# Doğum Günü Projesi
Doğum günlerini depolayan ve doğum günü ekleme/çıkarma/gösterme gibi basit operasyonları yapabilen program.
Doğum günlerini bir dosyada saklar.
(Proje tamamlanmadı.)

06/12/2021:
  1 haftadır JLabel'a `ImageIcon` eklemeyi beceremediğim için yeni release gelmedi.

09/12/2021:
  Fotoğraf ekleme sorununu çözdüm. Fotoğrafları yüklemek zaman gerektirdiği için programın başında yüklemek gerekiyormuş.

11/12/2021:
  Fotoğraf ekleme sorununu düzeltememişim. Bu yüzden fotoğraf eklememe kararı aldım.
  
13/12/2021:
  Üstte bahsettiğim tüm problemler, ```frame.setVisible(true)``` ifadesini sonda yazmak yerine başlarda yazmamdan kaynaklanıyormuş.
  Arama kutusu ekledim ama çalışmıyor.
  
19/12/2021:
  Arama kutusunu geliştirdim ama hala çalışmıyor. Dosyadan okunan değerler ile yeni paneller oluşturup bunları JScrollPane ile gezebiliyorum. Doğumgünleri `bottomPanel`'de listeleniyor.

25/12/2021:
  O günün tarihine en yakın olan doğumgününü bulma algoritmasını ekledim.
  
04/01/2022:
 Doğum günü eklemeyi sağlayacak yeni bir panel ve buton ekledim.

07/01/2022:
  Programın ilk erken erşimini açtım. Program şu anda arama hariç açıklamada bahsedilen temel işlemleri yapabilir hale getirildi.

23/01/2022:
  En yakın doğum gününü bulan algoritmadaki hatayı giderdim.

19/02/2022:
  Doğumgünü eklerken günlerin yanlış alınmasına sebep olan bir hataya geçici bir çözüm getirdim.

20/02/2022:
  Program ilk açıldığında çıkan menüde '\' karakteri ile '/' karakterinin oluşturduğu düzensizliği giderdim.
