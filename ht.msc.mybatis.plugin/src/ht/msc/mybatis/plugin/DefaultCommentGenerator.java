package ht.msc.mybatis.plugin;

import java.util.Date;
import java.util.Properties;

public class DefaultCommentGenerator implements CommentGenerator
{
	private Properties properties;
	private boolean suppressDate;
	private boolean suppressAllComments;
	
	public DefaultCommentGenerator()
	{
	  this.properties = new Properties();
	  this.suppressDate = false;
	  this.suppressAllComments = false;
	}
	
	public void addJavaFileComment(CompilationUnit compilationUnit)
	{
	}
	
	public void addComment(XmlElement xmlElement)
	{
	  if (this.suppressAllComments) {
	    return;
	  }
	
	  builderComment(xmlElement);
	}
	
	private void builderComment(XmlElement xmlElement)
	{
	  xmlElement.addElement(new TextElement("<!--"));
	
	  StringBuilder sb = new StringBuilder();
	  sb.append("  WARNING - ");
	  sb.append("@mbggenerated");
	  xmlElement.addElement(new TextElement(sb.toString()));
	  xmlElement
	    .addElement(new TextElement(
	    "  This element is automatically generated by MyBatis Generator, do not modify."));
	
	  String s = getDateString();
	  if (s != null) {
	    sb.setLength(0);
	    sb.append("  This element was generated on ");
	    sb.append(s);
	    sb.append('.');
	    xmlElement.addElement(new TextElement(sb.toString()));
	  }
	
	  xmlElement.addElement(new TextElement("-->"));
	}
	
	public void addComment(XmlElement xmlElement, boolean suppressComments)
	{
	  if (suppressComments) {
	    return;
	  }
	
	  builderComment(xmlElement);
	}
	
	public void addRootComment(XmlElement rootElement)
	{
	}
	
	public void addConfigurationProperties(Properties properties)
	{
	  this.properties.putAll(properties);
	
	  this.suppressDate = StringUtility.isTrue(properties
	    .getProperty("suppressDate"));
	
	  this.suppressAllComments = StringUtility.isTrue(properties
	    .getProperty("suppressAllComments"));
	}
	
	protected void addJavadocTag(JavaElement javaElement, boolean markAsDoNotDelete)
	{
	  javaElement.addJavaDocLine(" *");
	  StringBuilder sb = new StringBuilder();
	  sb.append(" * ");
	  sb.append("@mbggenerated");
	  if (markAsDoNotDelete) {
	    sb.append(" do_not_delete_during_merge");
	  }
	  String s = getDateString();
	  if (s != null) {
	    sb.append(' ');
	    sb.append(s);
	  }
	  javaElement.addJavaDocLine(sb.toString());
	}
	
	protected String getDateString()
	{
	  if (this.suppressDate) {
	    return null;
	  }
	  return new Date().toString();
	}
	
	public void addClassComment(JavaElement javaElement)
	{
	}
	
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable)
	{
	  if (this.suppressAllComments) {
	    return;
	  }
	
	  StringBuilder sb = new StringBuilder();
	
	  innerClass.addJavaDocLine("/**");
	  innerClass
	    .addJavaDocLine(" * This class was generated by MyBatis Generator.");
	
	  sb.append(" * This class corresponds to the database table ");
	  sb.append(introspectedTable.getFullyQualifiedTable());
	  innerClass.addJavaDocLine(sb.toString());
	
	  addJavadocTag(innerClass, false);
	
	  innerClass.addJavaDocLine(" */");
	}
	
	public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable)
	{
	  if (this.suppressAllComments) {
	    return;
	  }
	
	  StringBuilder sb = new StringBuilder();
	
	  innerEnum.addJavaDocLine("/**");
	  innerEnum
	    .addJavaDocLine(" * This enum was generated by MyBatis Generator.");
	
	  sb.append(" * This enum corresponds to the database table ");
	  sb.append(introspectedTable.getFullyQualifiedTable());
	  innerEnum.addJavaDocLine(sb.toString());
	
	  addJavadocTag(innerEnum, false);
	
	  innerEnum.addJavaDocLine(" */");
	}
	
	public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
	{
	  if (this.suppressAllComments) {
	    return;
	  }
	
	  StringBuilder sb = new StringBuilder();
	
	  field.addJavaDocLine("/**");
	  field
	    .addJavaDocLine(" * This field was generated by MyBatis Generator.");
	
	  sb.append(" * This field corresponds to the database column ");
	  sb.append(introspectedTable.getFullyQualifiedTable());
	  sb.append('.');
	  sb.append(introspectedColumn.getActualColumnName());
	  field.addJavaDocLine(sb.toString());
	
	  addJavadocTag(field, false);
	
	  field.addJavaDocLine(" */");
	}
	
	public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
	  if (this.suppressAllComments) {
	    return;
	  }
	
	  StringBuilder sb = new StringBuilder();
	
	  field.addJavaDocLine("/**");
	  field
	    .addJavaDocLine(" * This field was generated by MyBatis Generator.");
	
	  sb.append(" * This field corresponds to the database table ");
	  sb.append(introspectedTable.getFullyQualifiedTable());
	  field.addJavaDocLine(sb.toString());
	
	  addJavadocTag(field, false);
	
	  field.addJavaDocLine(" */");
	}
	
	public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable)
	{
	  if (this.suppressAllComments) {
	    return;
	  }
	
	  StringBuilder sb = new StringBuilder();
	
	  method.addJavaDocLine("/**");
	  method
	    .addJavaDocLine(" * This method was generated by MyBatis Generator.");
	
	  sb.append(" * This method corresponds to the database table ");
	  sb.append(introspectedTable.getFullyQualifiedTable());
	  method.addJavaDocLine(sb.toString());
	
	  addJavadocTag(method, false);
	
	  method.addJavaDocLine(" */");
	}
	
	public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
	{
	  if (this.suppressAllComments) {
	    return;
	  }
	
	  StringBuilder sb = new StringBuilder();
	
	  method.addJavaDocLine("/**");
	  method
	    .addJavaDocLine(" * This method was generated by MyBatis Generator.");
	
	  sb.append(" * This method returns the value of the database column ");
	  sb.append(introspectedTable.getFullyQualifiedTable());
	  sb.append('.');
	  sb.append(introspectedColumn.getActualColumnName());
	  method.addJavaDocLine(sb.toString());
	
	  method.addJavaDocLine(" *");
	
	  sb.setLength(0);
	  sb.append(" * @return the value of ");
	  sb.append(introspectedTable.getFullyQualifiedTable());
	  sb.append('.');
	  sb.append(introspectedColumn.getActualColumnName());
	  method.addJavaDocLine(sb.toString());
	
	  addJavadocTag(method, false);
	
	  method.addJavaDocLine(" */");
	}
	
	public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn)
	{
	  if (this.suppressAllComments) {
	    return;
	  }
	
	  StringBuilder sb = new StringBuilder();
	
	  method.addJavaDocLine("/**");
	  method
	    .addJavaDocLine(" * This method was generated by MyBatis Generator.");
	
	  sb.append(" * This method sets the value of the database column ");
	  sb.append(introspectedTable.getFullyQualifiedTable());
	  sb.append('.');
	  sb.append(introspectedColumn.getActualColumnName());
	  method.addJavaDocLine(sb.toString());
	
	  method.addJavaDocLine(" *");
	
	  Parameter parm = (Parameter)method.getParameters().get(0);
	  sb.setLength(0);
	  sb.append(" * @param ");
	  sb.append(parm.getName());
	  sb.append(" the value for ");
	  sb.append(introspectedTable.getFullyQualifiedTable());
	  sb.append('.');
	  sb.append(introspectedColumn.getActualColumnName());
	  method.addJavaDocLine(sb.toString());
	
	  addJavadocTag(method, false);
	
	  method.addJavaDocLine(" */");
	}
	
	public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete)
	{
	  if (this.suppressAllComments) {
	    return;
	  }
	
	  StringBuilder sb = new StringBuilder();
	
	  innerClass.addJavaDocLine("/**");
	  innerClass
	    .addJavaDocLine(" * This class was generated by MyBatis Generator.");
	
	  sb.append(" * This class corresponds to the database table ");
	  sb.append(introspectedTable.getFullyQualifiedTable());
	  innerClass.addJavaDocLine(sb.toString());
	
	  addJavadocTag(innerClass, markAsDoNotDelete);
	
	  innerClass.addJavaDocLine(" */");
	}
}