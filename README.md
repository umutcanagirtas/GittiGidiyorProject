# Testinium-Project

Selenium, allure ve Log4j framework kullanarak birkaç senaryo üzerinden UI Test projesi oluşturdum. Test sonuçlarının raporlanması için Log4j, monitoring edilmesi için de allure yapısını kullandım. Bu proje Web Sitesinin(GittiGidiyor) girilen parametrelere göre doğru  çıktıyı verip vermediğinin kontrollerinin yapıldığı ve bunların yönetilmesini sağlayan monitoring logging yardımıyla çok amaçlı olarak isteğe göre değiştirilebilir bir projedir. 

## Kullanılan Teknolojiler

- Java (Projenin yazılmış olduğu kodlama dilidir);
- TestNG(Test Caselerin yazılması ve çıktıların kontrollerinde kullanılan Test Yazım Aracıdır);
- Selenium (Web Sitesini test etmek için kullanılan Test Otomasyon Aracıdır);
- Allure (Test Sonuclarının monitorize edilmesini sağlar);
- Log4J (Hata sonuclarının loglanmasını sağlar).

## Proje Yapısının Açıklanması

Projede aşşağıda görmüş olduğunuz yapıyı kullandım;

![proje yapısı](https://user-images.githubusercontent.com/56224909/119259011-dec75b80-bbd4-11eb-850f-3d91e913f594.png)

+ **Base:** BaseClass sınıfının bulunduğu klasör. Bu sınıf ile driverları ayağa kaldırma, ilk url girme, driver sonlandırma gibi işlemler yapılabilir.
+ **Helpers:** Sistemde birden fazla yerde kullanılacağını düşündüğüm metodları bu klasör altında topladım. Böylelikle kod tekrarını önleyip okunaklığı arttırabileceğini düşündüm. Helpers klasörü altında; ActionClass, CustomElementWaits, DataHelpers, Listeners ve Log sınıfları bulunur. 
  + **ActionClass:** Sayfa aksiyonlarının artması durumunda(moveTo gibi) işimizi kolaylaştırabilecek bir yapıdır. Şuanki tek amacı elementleri görünür olana dek sayfayı harekeket ettirmektir.
  + **CustomElementWaits:** Sayfa Yüklenirken geç gelen elementleri beklememizi kolaylaştıran bir sınıftır(clickable, visibility ve findall gibi).
  + **DataHelpers:** Listelerden random bir şekilde eleman çekmemize yarayan bir sınıftır.
  + **Listeners:** Projede bulunan caseleri dinleyen bir yapıdır.
  + **Log:** Loglama yapmamızı sağlayan bir yapıdır.
+ **Pages:** Pages klasörünün yaratılma sebebi Pape Object Pattern kalıbını uylamaktır. İçerisinde caselerde kullanılan tüm sayfalar sınıflar aracılığıyla temsil edilir. Pages Klasörü içerisinde; BasketPage, HomePage, ItemPage, LoginPage, SearchPage sınıfları bulunur.
  + **BasketPage:** Kullanıcı Sepeti Sayfasıdır. Ürün fiyat sorgusu, sepette adet attırma ve sepetten ürün çıkarma işlemleri bu sayfa üzerinden yapılır.
  + **HomePage:** Kullanıcıyı karşılayan Ana Sayfadır(gittigidiyor.com). Login için ilk hareket ve ürün arama işlemleri bu sayfa üzerinden yapılır.
  + **ItemPage:** Ürün Sayfasıdır. Ürün bilgileri bu sayfa üzerinden kontrol edilir.
  + **LoginPage:** Üye Giriş Sayfasıdır. Kullanıcı login işlemleri bu sayfa üzerinden yapılır. 
  + **SearchPage:** Ürün Listelemelerinin Yapıldığı Sayfadır. Bu sayfa üzerinden ürün seçme, kategorileme işlemleri yapılır.
+ **Tests:** Testcaselerin yazılmış olduğu sınıfları içerir. Şuan içerisinde 1 sınıf bulunuyor. Case yönetimi açısından ayrı sınıflara ayrılıp bağımlılığı sıfıra indirmek gerekir.
+ **resources:** Allure, log4j ve testng'nın yönetilmesini kolaylaştırmak için oluşturulmuş bir klasörleme yapısıdır. Log4j ve allure sonuçlarını target klasörü altına yerleştirmeme yardımcı olur. testng.xml yardımı ile yazılan caselerin yönetimi kolaylaşır(case üzerine parametre atma, caseleri suitelere ayırma gibi).
+ **pom.xml:** Maven projesi ile gelen bir xml dosyasıdır. Projede kullanılacak olan frameworkleri tanımladığımız bir yapıdır.

## Projenin Ayağa Kaldırılması

1. İlk olarak projede bulunan resources klasörü içerisinde değişiklik yapılmalıdır. testng.xml dosyasında parametre bölümleri değiştirilmeliki proje de kendi login işlemlerinizi ve aramak istediğiniz ürünleri seçebilesiniz. log4j.properties ve allure.properties dosyalarında kendi pathlerinizi ayarlamanız gerekir.
2. BaseClass içerisinde driver kaldırma sırasında bilgisayarınızda ki driver pathlerini vermemiz gerekir.
3. Allure monitoring kullanmak isterseniz de bilgisayarınızda allure'nin yüklü olması gerekiyor.

## Allure Monitoring Kullanımı

Allure yapısı caseler her tamamlandıktan sonra belirtilen path e kaydediliyor. Bunları görüntülemek için komut satırını açıp "allure serve [config dosyasında ayarladığınız path]\allure-results" girerseniz browserda açılan pencere üzerinde detaylı inceleme yapabilirsiniz.

![allure monitoring](https://user-images.githubusercontent.com/56224909/119260520-cb6bbe80-bbdb-11eb-9ba4-bf7b736000fb.png)

## Örnek Ekran Çıktıları

- Log Yapısının Örnek çıktısı:

![log4j örnek ekran çıktısı](https://user-images.githubusercontent.com/56224909/119260686-8dbb6580-bbdc-11eb-9d36-77e522521e4e.png)

- Allure Succes Case Ekran Görüntüsü

![allure success](https://user-images.githubusercontent.com/56224909/119261006-fc4cf300-bbdd-11eb-983a-414d3294f0a3.png)

- Allure Fail Case Ekran Görüntüsü

![allure fail](https://user-images.githubusercontent.com/56224909/119261023-11298680-bbde-11eb-9b21-71072304c6dc.png)

