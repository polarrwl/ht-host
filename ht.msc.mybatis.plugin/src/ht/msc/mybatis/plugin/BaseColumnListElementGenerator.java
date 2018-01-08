package ht.msc.mybatis.plugin;

import java.util.Iterator;


public class BaseColumnListElementGenerator extends AbstractXmlElementGenerator
{
  public void addElements(XmlElement parentElement)
  {
    XmlElement answer = new XmlElement("sql");

    answer.addAttribute(new Attribute("id", 
      this.introspectedTable.getBaseColumnListId()));

    this.context.getCommentGenerator().addComment(answer);

    StringBuilder sb = new StringBuilder();
    Iterator iter = this.introspectedTable
      .getNonBLOBColumns().iterator();
    while (iter.hasNext()) {
      sb.append(MyBatis3FormattingUtilities.getSelectListPhrase(
        (IntrospectedColumn)iter
        .next()));

      if (iter.hasNext()) {
        sb.append(", ");
      }

      if (sb.length() > 80) {
        answer.addElement(new TextElement(sb.toString()));
        sb.setLength(0);
      }
    }

    if (sb.length() > 0) {
      answer.addElement(new TextElement(sb.toString()));
    }

    if (this.context.getPlugins().sqlMapBaseColumnListElementGenerated(
      answer, this.introspectedTable))
      parentElement.addElement(answer);
  }
}