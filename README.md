# Toyota-Projesi
Spring Mvc Web Projesi

## Neden bu proje?
Öncelikle bu projemde bana verdiği eğitim ve emeği için Hocam Levent Ergüder e teşekkürü bir borç bilirim.
*Bu proje benim ilk Spring projem ve bu projeyi yapmak için daha önce herzaman yaptığım gibi kendi isteğime göre bir proje değil de
dışarıdan isteklerin olduğu yani bana bir proje şablonu verilip oradaki istekleri yapmaya çalıştığım bir proje olması gerekliydi.
Bunun için Hocam Levent Ergüder'den aldığım sakarya üniversitesinde toyotanın kendi stajerleri için hazırladığı Toyota Proje sini yapmaya karar verdim.
Bu Projenin nasıl bir yapıda olduğunu [buradan](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/Toyota_Proje.pdf) öğrenebilirsiniz.*
</br></br>
## Proje Açıklaması
*Proje, verilen taslakta yapılmak istenen herşeyi yapabilecek şekilde tasarlanmıştır.Proje bir Maven Projesidir.Bağımlılıkları buradan [pom.xml](https://github.com/anlrcavictor/Toyota-Projesi/blob/master/ToyotaProje/pom.xml) 
inceleyebilirsiniz.*
</br>
*Projede JPA İmplementation Eclipselink,Spring MVC kullanılmıştır.Veri Tabanı olarak MySQL kullanılmıştır.Proje yapısında domain katmanında veri model sınıfları(POJO),Form Model katmanında
Spring MVC Model 2 için gerekli model classları(Viev Katmanında modelin güncellenmesi için gereken ek model classları) dao katmanında veri 
tabanı işlemleri,Service katmanında business logic işlemleri,Controller da ise sadece dispatch işlemleri yapılmıştır.*
</br></br>
# Project Structure 
![Structure](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/Structure.png?raw=true)
</br></br>
*Projede istenen taslakta olduğu gibi uygun validasyonlar ve gerekli validasyonlar springin `org.springframework.validation.Validator` sınıfının
kolaylıkları kullanılarak yapılmıştır.*[İnceleyebilirsiniz](https://github.com/anlrcavictor/Toyota-Projesi/tree/master/ToyotaProje/src/validator)
</br></br>
#### Validasyon
![Validation](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/Validation.png?raw=true)
</br></br>
*Projede istenen taslakta olduğu gibi uygun bir şekilde authorization ve authentication işlemleri,2 rol ADMIN,USER rolleri için yapılmıştır.
Bu işlem için Spring Security kullanmak istedim.Ama webde aradığım tüm çözümlerin ORM aracı Hibernate Core ile birlikte yapılması sebebi ve 
Hibernate Core a çok hakim olmadığım için malesef kullanamadım.Bu işlemi [AuthorizationInterceptor](https://github.com/anlrcavictor/Toyota-Projesi/blob/master/ToyotaProje/src/interceptor/AuthorizationInterceptor.java) sınıfını kullanarak 
ve `org.springframework.web.servlet.handler.HandlerInterceptorAdapter` sınıfının kolaylıklarını kullanarak yapabildim.*
</br></br>
#### Login
![Login](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/Login.png?raw=true)
</br></br>
#### User Sayfası
![User](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/UserTravels.png?raw=true)
</br></br>
#### Admin Sayfası
![Admin](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/AdminTravels.png?raw=true)
</br></br>
*Proje taslağında listelenen seyahatlerin Excel olarak çıktısının alınması gerekiyordu. bu işlem için `org.springframework.web.servlet.view.document.AbstractExcelView` 
sınıfından yararlandım.Güncel bir çözüm değildir `AbstarctExcelView` sınıfı deprecated olmuş bir spring framework sınıfıdır.Çözümü [inceleyebilirsiniz.](https://github.com/anlrcavictor/Toyota-Projesi/blob/master/ToyotaProje/src/service/ExcelView.java)*
</br></br>
#### Extract Excel
![ExtractExcel](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/ExtractExcel.png?raw=true)
</br></br>
![Excel](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/Excel.png?raw=true)
</br></br>
*Projeyi yükleyip incelemek isteyenler için sadece veri tabanınızı oluşturup ismini [Persistence.xml](https://github.com/anlrcavictor/Toyota-Projesi/blob/master/ToyotaProje/persistence/META-INF/persistence.xml) dosyasında 
`javax.persistence.jdbc.url` property alanına göstermeniz yeterli olacaktır.*
</br></br>
#### Persistence.xml 
![PersistenceSettings](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/persistenceSettings.png?raw=true)

#### Eksik Gördüklerim
*Proje bir web sitesinin olması gereken tüm özelliklerini kapsamakla beraber tek eksiğinin kullanıcıların şifrelerini veri tabanına direkt 
olarak kaydetmesidir. Bir şifreleme algoritması kullanılmamıştır.(SHA2 vb.)*
</br>
*Yine bir eksik olarak proje  Internationalization a uygun hale getirilmemiştir.Ayrıyeten Datepickeri türkçeleştiremedim.Kullanılan DatePicker
in çok yönlü konfigürasyona müsait olmaması ve eksik Jquery bilgim buna yeterli olmadı.*
</br></br>
#### Projeden Görünümler
![HomePage](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/HomePage.png?raw=true)
</br></br></br></br>
![Profile](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/Profile.png?raw=true)
</br></br></br></br>
![SearchTravel](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/SearchedTravel.png?raw=true)
</br></br></br></br>
![Users](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/Users.png?raw=true)
</br></br></br></br>
![Logout](https://github.com/anlrcavictor/ImagesRepo-for-Readme/blob/master/Toyota%20Projesi/Logout.png?raw=true)

