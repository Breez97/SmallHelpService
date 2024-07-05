package com.breez.help;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ServletManagerTest {

	@InjectMocks
	private ServletManager servletManager;

	@Mock
	private MemRepository memRepository;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	@Mock
	private PrintWriter writer;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testDoPost_NewPhrase_1() throws Exception {
		when(request.getParameter("phrase")).thenReturn("New Phrase");
		when(memRepository.addPhrase("New Phrase")).thenReturn(false);
		when(response.getWriter()).thenReturn(writer);

		servletManager.doPost(request, response);

		verify(response).setContentType("text/html");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(writer).println(captor.capture());
		assertEquals("New phrase: <New Phrase> added successfully", captor.getValue());
	}

	@Test
	void testDoPost_NewPhrase_2() throws Exception {
		when(request.getParameter("phrase")).thenReturn("Hello world");
		when(memRepository.addPhrase("Hello world")).thenReturn(false);
		when(response.getWriter()).thenReturn(writer);

		servletManager.doPost(request, response);

		verify(response).setContentType("text/html");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(writer).println(captor.capture());
		assertEquals("New phrase: <Hello world> added successfully", captor.getValue());
	}

	@Test
	void testDoPost_ExistingPhrase_1() throws Exception {
		when(request.getParameter("phrase")).thenReturn("You will succeed");
		when(memRepository.addPhrase("You will succeed")).thenReturn(true);
		when(response.getWriter()).thenReturn(writer);

		servletManager.doPost(request, response);

		verify(response).setContentType("text/html");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(writer).println(captor.capture());
		assertEquals("This phrase is already exist", captor.getValue());
	}

	@Test
	void testDoPost_ExistingPhrase_2() throws Exception {
		when(request.getParameter("phrase")).thenReturn("Hello world");
		when(memRepository.addPhrase("Hello world")).thenReturn(true);
		when(response.getWriter()).thenReturn(writer);

		servletManager.doPost(request, response);

		verify(response).setContentType("text/html");
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(writer).println(captor.capture());
		assertEquals("This phrase is already exist", captor.getValue());
	}
}
