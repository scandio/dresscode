package de.scandio.dresscode;

/**
 * TODO: description
 *
 * @author Georg Schmidl <georg.schmidl@scandio.de>
 */
public interface ArticleForm extends Form {

    Field<String> getTitle();

    Field<Integer> getNumber();
}
