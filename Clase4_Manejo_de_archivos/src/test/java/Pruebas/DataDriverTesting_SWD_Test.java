package Pruebas;

//E. Creamos el JUnit_test_Case de prueba

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriverTesting_SWD_Test {

	private WebDriver driver;
	//como vamos a leer y escribir vamos a crear dos objetos de las clases
	//que creamos previamente.
	private WriteExcelFile writeFile;
	private ReadExcelFile readFile;
     	
	
	
	//F. Definimos los objetos Locators
	//Localizamos la caja de busqueda
	private By searchBoxLocator = By.id("search_query_top");
	//Localizamos el boton
	private By searchButtonLocator = By.name("submit_search");
	//Localizamos el texto donde estan los resultados, que aparecen una vez que realizamos la busqueda
	private By resutTextLocator = By.cssSelector("span.heading-counter");
	
	 
	//G. Seteos previos
	
	@Before
	public void setUp() throws Exception {
			
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		writeFile = new WriteExcelFile();
		readFile = new ReadExcelFile();
		System.out.println("Estamos en el Before Test");
		driver.get("http://automationpractice.com");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	//H. Implementamos la prueba
	
	@Test
	public void test() throws IOException {
	     String filepath = "C:\\Users\\lrlopez\\Desktop\\TESTING AUTOMATION CON SELENIUM\\CLASE 4\\Test.xlsx";
	    
	     for (int i = 0; i < 3; i++) {
	     driver.findElement(searchBoxLocator).clear();
	
	     
	     //termino que vamos a buscar, es el 1er elemento de la 1era fila en el excel (fila 0, celda 0), y lo 
	     //guardamos en searchText
	     String searchText = readFile.getCellValue(filepath, "Hoja1", i, 0); 
	     
	     //agarramos el primer valor del excel y vamos a buscarlo en la pagina
	     driver.findElement(searchBoxLocator).sendKeys(searchText);
	     driver.findElement(searchButtonLocator).click();
	     
	     //Obtenemos el texto con la "cantidad de productos encontrados"
	     String resultText = driver.findElement(resutTextLocator).getText();
	     //mostramos por consola el mensaje devuelto por la pagina, para que podamos confirmar que en esa variable se esta guardando lo que la pagina nos devuelve
	     System.out.println("Page result text: "+resultText+"\n");
	     
	     //Escribimos en el excel, en la celda de la coumna B el resultado que estamos obteniendo de la pagina
	     //1° Leemos lo que tiene la celda antes de escribir
	     System.out.println("\nANTES");
	     readFile.readExcel(filepath, "Hoja1");
	     //escribimos el resultText string que es la informacion que nos devuelve la pagina, en columna B
	     writeFile.writeCellValue(filepath, "Hoja1", i, 1, resultText); 
	     //Mostramos como quedo despues de escribir
	     System.out.println("\nDESPUES");
	     readFile.readExcel(filepath, "Hoja1"); //corroboramos que realmente se escribio ese valor correctamente
	 	
	     }
	 
	}

}
