package edu.neu.ccs.cs5004.model;

import java.util.Objects;

/**
 * Represents a template to communicate with members.
 */
public class Template implements TemplateI {
  private FileName templateName;


  /**
   * Creates a new abstract template with the given template name.
   *
   * @param templateName the given template name
   */
  public Template(FileName templateName) {
    this.templateName = templateName;
  }

  /**
   * Getter for the property 'templateName'.
   *
   * @return Value for property 'templateName'
   */
  public FileName getTemplateName() {
    return templateName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    Template that = (Template) other;
    return Objects.equals(getTemplateName(), that.getTemplateName());
  }

  @Override
  public int hashCode() {

    return Objects.hash(getTemplateName());
  }
}
