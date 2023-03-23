package com.hosinsa.crwaling;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.*;

import javax.imageio.ImageIO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.hosinsa.dto.ProductVO;

public class Product_Crawling_pants {
	static ArrayList<ProductVO> pantsList = new ArrayList<ProductVO>();
	
	public static void main(String[] args) {
		Product_Crawling_pants pcraw = new Product_Crawling_pants();
		pcraw.product_crawling();
	}
	
	public static ArrayList<ProductVO> product_crawling() {
		String category; //카테고리 
		String proname; //제품명
		String proimgSmall;
		String proimgBig;
		String brand; //브랜드
		int pronum; //품번
		int price; //가격
		int stock; //재고
		int proview; //조회수
		
		try {
			for(int i=1; i<=1; i++) {//120
//				Document doc_top = Jsoup.connect("https://www.musinsa.com/ranking/best?period=now&age=ALL&mainCategory=001&subCategory=&leafCategory=&price=&golf=false&kids=false&newProduct=false&exclusive=false&discount=false&soldOut=false&page="+i).get();
//				Document doc_outer = Jsoup.connect("https://www.musinsa.com/ranking/best?period=now&age=ALL&mainCategory=002&subCategory=&leafCategory=&price=&golf=false&kids=false&newProduct=false&exclusive=false&discount=false&soldOut=false&page="+i).get();
				Document doc_pants = Jsoup.connect("https://www.musinsa.com/ranking/best?period=now&age=ALL&mainCategory=003&subCategory=&leafCategory=&price=&golf=false&kids=false&newProduct=false&exclusive=false&discount=false&soldOut=false&page="+i).get();
//				Document doc_onepiece = Jsoup.connect("https://www.musinsa.com/ranking/best?period=now&age=ALL&mainCategory=020&subCategory=&leafCategory=&price=&golf=false&kids=false&newProduct=false&exclusive=false&discount=false&soldOut=false&page="+i).get();
//				Document doc_skirt = Jsoup.connect("https://www.musinsa.com/ranking/best?period=now&age=ALL&mainCategory=022&subCategory=&leafCategory=&price=&golf=false&kids=false&newProduct=false&exclusive=false&discount=false&soldOut=false&page="+i).get();
//				Document doc_shoes = Jsoup.connect("https://www.musinsa.com/ranking/best?period=now&age=ALL&mainCategory=005&subCategory=&leafCategory=&price=&golf=false&kids=false&newProduct=false&exclusive=false&discount=false&soldOut=false&page="+i).get();
//				Elements img_top =doc_top.select("div.list-box li.li_box img.lazyload");
//				Elements img_outer =doc_outer.select("div.list-box li.li_box img.lazyload");
				Elements img_pants =doc_pants.select("div.list-box li.li_box img.lazyload");
//				Elements img_onepiece =doc_onepiece.select("div.list-box li.li_box img.lazyload");
//				Elements img_skirt =doc_skirt.select("div.list-box li.li_box img.lazyload");
//				Elements img_shoes =doc_shoes.select("div.list-box li.li_box img.lazyload");

//				System.out.println(img_top.size());
//				System.out.println(img_outer.size());
//				System.out.println(img_pants.size());
//				System.out.println(img_onepiece.size());
//				System.out.println(img_skirt.size());
//				System.out.println(img_shoes.size());

				try {
					for(int j=0; j<img_pants.size(); j++) {
						Elements pNum = doc_pants.select("div.list-box li.li_box");
						Document doc2 = Jsoup.connect("https://www.musinsa.com/app/goods/"+pNum.get(j).attr("data-goods-no")+"?loc=goods_rank").get();
						Elements pName = doc_pants.select("div.list-box li.li_box div.article_info p.list_info a");
						Elements pBrand = doc_pants.select("div.list-box li.li_box div.article_info p.item_title a");
						Elements pPrice = doc2.select("ul.product_article #normal_price");
						Elements imgSmall = doc_pants.select("div.list-box li.li_box img.lazyload");
						Elements imgBig = doc2.select("div.wrap_product div.product-img img");
						
						String pCategory = "바지";
						int pNumber = Integer.parseInt(pNum.get(j).attr("data-goods-no"));
						int proPrice = Integer.parseInt(pPrice.get(0).text());
						int pStock = (int)(Math.random()*100+1);
						int pView = (int)(Math.random()*100+1);
						String urlSmall = imgSmall.get(j).attr("data-original");
						String urlBig = urlSmall.replace("_125", "_500");
						
						URL imgSmallUrl = new URL(urlSmall);
						URL imgBigUrl = new URL(urlBig);
						BufferedImage smalljpg = ImageIO.read(imgSmallUrl);
						BufferedImage bigjpg = ImageIO.read(imgBigUrl);
						
						System.out.println("번호 : "+(j+1));
						System.out.println("카테고리 : "+pCategory);
						System.out.println("제품명 : "+pName.get(j).attr("title"));
						System.out.println("이미지주소(소) : "+urlSmall);
						System.out.println("이미지주소(대) : "+urlBig);
						System.out.println("브랜드 : "+pBrand.get(j).text());
						System.out.println("제품번호 : "+pNumber);
						System.out.println("가 격 : "+pPrice.get(0).text());
						System.out.println("재 고 : "+pStock);
						System.out.println("조회수 : "+pView);
						System.out.println("==================================");
						
						File fileSmall = new File("C:\\Works2\\Hosinsa\\src\\main\\webapp\\product\\images\\바지\\small_"+pNumber+".jpg");
						File fileBig = new File("C:\\Works2\\Hosinsa\\src\\main\\webapp\\product\\images\\바지\\big_"+pNumber+".jpg");			
						ImageIO.write(smalljpg, "jpg", fileSmall);
						ImageIO.write(bigjpg, "jpg", fileBig);
						
						ProductVO vo = new ProductVO();
						category = pCategory;
						proname = pName.get(j).attr("title");
						proimgSmall = "product\\images\\바지\\small_"+pNumber+".jpg";
						proimgBig = "product\\images\\바지\\big_"+pNumber+".jpg";
						brand = pBrand.get(j).text();
						pronum = pNumber;
						price = proPrice;
						stock = pStock;
						proview = pView;
						
						vo.setCategory(category);
						vo.setProname(proname);
						vo.setProimgSmall(proimgSmall);
						vo.setProimgBig(proimgBig);
						vo.setBrand(brand);
						vo.setPronum(pronum);
						vo.setPrice(price);
						vo.setStock(stock);
						vo.setProview(proview);
						pantsList.add(vo);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pantsList;		
	}
}
