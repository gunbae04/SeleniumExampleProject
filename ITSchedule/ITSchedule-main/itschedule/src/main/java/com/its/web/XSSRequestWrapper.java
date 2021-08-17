package com.its.web;

import java.lang.Override;
import java.lang.String;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XSSRequestWrapper extends HttpServletRequestWrapper {
	
  /**
   * 
   * @param request
   */
  public XSSRequestWrapper(HttpServletRequest request) {
    super(request);
  }

  /**
   * 
   */
  @Override
  public String getHeader(String name) {
    String value = super.getHeader(name);
    return stripXSS(value);
  }

  /**
   * 
   */
  @Override
  public String getParameter(String name) {
    String value = super.getParameter(name);
    return stripXSS(value);
  }

  /**
   * 
   */
  @Override
  public String[] getParameterValues(String name) {
    String[] values = super.getParameterValues( name );
    if (values == null) {
      return null;
    }
    int count = values.length;
    String[] encodedValues = new String[count];
    for (int i = 0; i < count; i++) {
      encodedValues[i] = stripXSS(values[i]);
    }
    return encodedValues;
  }

  /**
   * 
   * @param value
   * @return
   */
  private String stripXSS(String value) {
    if (value != null) {
      value = value.replaceAll("", "");
      Pattern scriptPattern = null;
      scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
      scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
      scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
      scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
      scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
      scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
      scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
      value = scriptPattern.matcher(value).replaceAll("");
      scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
      value = scriptPattern.matcher(value).replaceAll("");
    }
    return value;
  }
}
