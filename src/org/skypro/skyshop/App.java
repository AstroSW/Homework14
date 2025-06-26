package org.skypro.skyshop;

import org.skypro.skyshop.Article.Article;
import org.skypro.skyshop.Search.SearchEngine;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();
        productBasket.addProduct(new SimpleProduct("Бананы", 170));
        productBasket.addProduct(new DiscountedProduct("Яблоки", 105, 10));
        productBasket.addProduct(new FixPriceProduct("Апельсины"));
        productBasket.addProduct(new SimpleProduct("Хлеб", 18));
        productBasket.addProduct(new DiscountedProduct("Шоколад", 90, 35));

        System.out.println();
        productBasket.addProduct(new SimpleProduct("Пельмени", 248));
        productBasket.printBasket();
        System.out.println();
        System.out.println("Стоимость корзины: "+ productBasket.countPriceBasket() +" р." );
        System.out.println();
        System.out.println("Хлеб "+ productBasket.findProduct("Хлеб"));
        System.out.println("Пельмени "+ productBasket.findProduct("Пельмени"));

        productBasket.emptyBasket();
        productBasket.printBasket();
        System.out.println("Стоимость корзины: "+ productBasket.countPriceBasket() +" р." );
        System.out.println("Хлеб "+ productBasket.findProduct("Хлеб"));

        SearchEngine searchEngine = new SearchEngine(10);
        searchEngine.addInfo(new SimpleProduct("iPhone 16", 20999));
        searchEngine.addInfo(new DiscountedProduct("Смартфон Xiaomi", 20999, 10));
        searchEngine.addInfo(new FixPriceProduct("Смартфон Samsung Galaxy"));
        searchEngine.addInfo(new SimpleProduct("Смартфон POCO", 35499));
        searchEngine.addInfo(new DiscountedProduct("Смартфон HONOR", 29499, 35));

        searchEngine.addInfo(new Article("Apple iPhone", "iPhone 16 создан вместе с Apple Intelligence, персональной интеллектуальной системой, которая помогает вам писать, выражать себя и выполнять задачи без усилий. Благодаря новаторской защите конфиденциальности вы можете быть уверены, что никто другой не сможет получить доступ к вашим данным — даже Apple. Apple Intelligence разработан для защиты вашей конфиденциальности на каждом этапе . Он интегрирован в ядро \u200B\u200BiPhone посредством обработки на устройстве. Поэтому он знает о вашей личной информации, не собирая ее. "));
        searchEngine.addInfo(new Article("Смартфон Xiaomi", "Xiaomi Redmi Note 14 оснащен мощным процессором MediaTek Helio G99 Ultra, что обеспечивает быструю и плавную работу устройства. Смартфон также имеет большой объем оперативной памяти LPDDR4X, что позволяет ему легко справляться с многозадачностью и запускать требовательные приложения. "));
        searchEngine.addInfo(new Article("Смартфон Samsung Galaxy", "Смартфон Samsung Galaxy S24 Ultra обладает 6.8-дюймовым дисплеем, который сконструирован на основе матрицы Dynamic AMOLED 2X. Она корректирует частоту обновления в соответствии с динамикой контента. Покрытие Corning Gorilla Armor не допускает образования сколов и царапин. Энергии аккумулятора достаточно для 95-часового прослушивания треков. Хранение файлов производится во встроенной памяти объемом 256 ГБ. "));
        searchEngine.addInfo(new Article("Смартфон POCO", "Смартфон имеет емкий аккумулятор на 6000 мАч, что обеспечивает длительное время работы без подзарядки. POCO X7 Pro также поддерживает быструю зарядку мощностью 90 Вт, что позволяет быстро восстановить заряд батареи. "));
        searchEngine.addInfo(new Article("Смартфон HONOR", "Оптическая стабилизация позволяет получать четкое изображение в движении или при недостаточном освещении, обеспечивая непревзойденное качество фото и видео. Два динамика и режим увеличения громкости на 300% создают объемное и насыщенное звучание. "));

        searchEngine.searchInfo("Samsung");
        searchEngine.searchInfo("емкий аккумулятор");
        searchEngine.searchInfo("Смартфон");
    }
}