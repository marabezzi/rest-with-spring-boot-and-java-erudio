package br.com.erudio.unittests.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.erudio.converter.DozerConverter;
import br.com.erudio.data.vo.v1.BookVO;
import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.model.Book;
import br.com.erudio.model.Person;
import br.com.erudio.unittests.mapper.mocks.MockBook;
import br.com.erudio.unittests.mapper.mocks.MockPerson;

public class DozerConverterTest {
	
    MockPerson inputPerson;
    MockBook inputBook; 

    @Before
    public void setUp() {
        inputPerson = new MockPerson();
        inputBook = new MockBook();
    }

    @Test
    public void parseEntityToVOTestPerson() {
        PersonVO outputPerson = DozerConverter.parseObject(inputPerson.mockEntity(), PersonVO.class);
        Assert.assertEquals(Long.valueOf(0L), outputPerson.getKey());
        Assert.assertEquals("First Name Test0", outputPerson.getFirstName());
        Assert.assertEquals("Last Name Test0", outputPerson.getLastName());
        Assert.assertEquals("Addres Test0", outputPerson.getAddress());
        Assert.assertEquals("Male", outputPerson.getGender());
        
        
    }

    @Test
    public void parseEntityListToVOListTestPerson() {
        List<PersonVO> outputList = DozerConverter.parseListObjects(inputPerson.mockEntityList(), PersonVO.class);
        PersonVO outputPersonZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputPersonZero.getKey());
        Assert.assertEquals("First Name Test0", outputPersonZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputPersonZero.getLastName());
        Assert.assertEquals("Addres Test0", outputPersonZero.getAddress());
        Assert.assertEquals("Male", outputPersonZero.getGender());
        
        PersonVO outputPersonSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputPersonSeven.getKey());
        Assert.assertEquals("First Name Test7", outputPersonSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputPersonSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputPersonSeven.getAddress());
        Assert.assertEquals("Female", outputPersonSeven.getGender());
        
        PersonVO outputPersonTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputPersonTwelve.getKey());
        Assert.assertEquals("First Name Test12", outputPersonTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputPersonTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputPersonTwelve.getAddress());
        Assert.assertEquals("Male", outputPersonTwelve.getGender());
    }

    @Test
    public void parseVOToEntityTestPerson() {
        Person outputPerson = DozerConverter.parseObject(inputPerson.mockVO(), Person.class);
        Assert.assertEquals(Long.valueOf(0L), outputPerson.getId());
        Assert.assertEquals("First Name Test0", outputPerson.getFirstName());
        Assert.assertEquals("Last Name Test0", outputPerson.getLastName());
        Assert.assertEquals("Addres Test0", outputPerson.getAddress());
        Assert.assertEquals("Male", outputPerson.getGender());
    }

    @Test
    public void parserVOListToEntityListTestPerson() {
        List<Person> outputList = DozerConverter.parseListObjects(inputPerson.mockVOList(), Person.class);
        Person outputPersonZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputPersonZero.getId());
        Assert.assertEquals("First Name Test0", outputPersonZero.getFirstName());
        Assert.assertEquals("Last Name Test0", outputPersonZero.getLastName());
        Assert.assertEquals("Addres Test0", outputPersonZero.getAddress());
        Assert.assertEquals("Male", outputPersonZero.getGender());
        
        Person outputPersonSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputPersonSeven.getId());
        Assert.assertEquals("First Name Test7", outputPersonSeven.getFirstName());
        Assert.assertEquals("Last Name Test7", outputPersonSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputPersonSeven.getAddress());
        Assert.assertEquals("Female", outputPersonSeven.getGender());
        
        Person outputPersonTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputPersonTwelve.getId());
        Assert.assertEquals("First Name Test12", outputPersonTwelve.getFirstName());
        Assert.assertEquals("Last Name Test12", outputPersonTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputPersonTwelve.getAddress());
        Assert.assertEquals("Male", outputPersonTwelve.getGender());
    }
    
    @Test
    public void parseEntityToVOTestBook() {
        BookVO outputBook = DozerConverter.parseObject(inputBook.mockEntity(), BookVO.class);
		Assert.assertEquals("Some Author1", outputBook.getAuthor());
		Assert.assertEquals("Some Title1", outputBook.getTitle());
		Assert.assertEquals("25D", outputBook.getPrice());
		Assert.assertNotNull(outputBook.getLaunchDate());
    }

    @Test
    public void parseEntityListToVOListTestBook() {
        List<BookVO> outputList = DozerConverter.parseListObjects(inputBook.mockEntityList(), BookVO.class);
        BookVO outputBookZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputBookZero.getKey());
        Assert.assertEquals("Some Author1", outputBookZero.getAuthor());
		Assert.assertEquals("Some Title1", outputBookZero.getTitle());
		Assert.assertEquals("25D", outputBookZero.getPrice());
		Assert.assertNotNull(outputBookZero.getLaunchDate());
        
        BookVO outputBookSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputBookSeven.getKey());
        Assert.assertEquals("Some Author1", outputBookSeven.getAuthor());
		Assert.assertEquals("Some Title1", outputBookSeven.getTitle());
		Assert.assertEquals("25D", outputBookSeven.getPrice());
		Assert.assertNotNull(outputBookSeven.getLaunchDate());
        
        BookVO outputBookTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputBookTwelve.getKey());
        Assert.assertEquals("Some Author1", outputBookTwelve.getAuthor());
		Assert.assertEquals("Some Title1", outputBookTwelve.getTitle());
		Assert.assertEquals("25D", outputBookTwelve.getPrice());
		Assert.assertNotNull(outputBookTwelve.getLaunchDate());
    }

    @Test
    public void parseVOToEntityTestBook() {
        Book outputBook = DozerConverter.parseObject(inputBook.mockVO(), Book.class);
        Assert.assertEquals(Long.valueOf(12L), outputBook.getId());
        Assert.assertEquals("Some Author1", outputBook.getAuthor());
		Assert.assertEquals("Some Title1", outputBook.getTitle());
		Assert.assertEquals("25D", outputBook.getPrice());
		Assert.assertNotNull(outputBook.getLaunchDate());
    }

    @Test
    public void parserVOListToEntityListTestBook() {
        List<BookVO> outputBookList = DozerConverter.parseListObjects(inputBook.mockVOList(), BookVO.class);
        BookVO outputBookZero = outputBookList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputBookZero.getKey());
        Assert.assertEquals("Some Author1", outputBookZero.getAuthor());
		Assert.assertEquals("Some Title1", outputBookZero.getTitle());
		Assert.assertEquals("25D", outputBookZero.getPrice());
		Assert.assertNotNull(outputBookZero.getLaunchDate());
        
        BookVO outputBookSeven = outputBookList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputBookSeven.getKey());
        Assert.assertEquals("Some Author1", outputBookSeven.getAuthor());
		Assert.assertEquals("Some Title1", outputBookSeven.getTitle());
		Assert.assertEquals("25D", outputBookSeven.getPrice());
		Assert.assertNotNull(outputBookSeven.getLaunchDate());
        
        BookVO outputBookTwelve = outputBookList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputBookTwelve.getKey());
        Assert.assertEquals("Some Author1", outputBookTwelve.getAuthor());
		Assert.assertEquals("Some Title1", outputBookTwelve.getTitle());
		Assert.assertEquals("25D", outputBookTwelve.getPrice());
		Assert.assertNotNull(outputBookTwelve.getLaunchDate());
    }
}
