Dresscode is a form-object based validation framework that is completely independent from your models.

**NOTE: Dresscode is not fully implemented yet**



Example
----------

### Define your Form

    public interface ArticleForm() {

    	@Length(200)                                            // max length of 200
        @Required                                               // requred
        Field<String, TextValidator> getTitle();                // normal String input

        Field<String, TextValidator> getContent();              // unrestricted

        ListField<String, TextValidator> getCategories();       // multi select input

        Field<Boolean, BooleanValidator> getSendToTwitter();    // checkbox

        @Format("YYYY-MM-DD")                                   // date format
        Field<Date, DateValidator> getPublishDate();            // date field

        @Required(3)                                            // minimum of 3 tags required
        FieldList<String, TextValidator> getTags();             // list of strings

        Field<String, EmailValidator> getEmail();               // Email

        @Min(42) @Max(42)
        Field<IntegerValidator> getAnswerToLifeTheUniverseAndEverything();
    }


### Usage in controller
    public class ArticleController {

    	// create article action
    	public String createArticle(Request request) {
    		// crete a new article form
    		ArticleForm form = Dresscode.create(ArticleForm.class);

    		// set category options
    		form.getCategories().setOptions(Categories.getAll());
    		// set the default selected category
    		form.getCategories().setValue("default");

    		return CoolTemplateEngine.render("createarticle.template", form);
    	}

    	// save article action
    	public String saveArticle(Request request) {
    		// create an article form filled from request parameters
    		ArticleForm form = Dresscode.fromRequest(ArticleForm.class, request);

    		if (form.isValid()) { // validate
    			// create article entity from form (not scope of Dresscode)
    			Article article = entityManager.fromForm(Article.class, form);
    			article.save();
    			return CoolTemplateEngine.render("success.template");
    		} else {
    			// form has errors. return to sender.
    			return CoolTemplateEngine.render("createarticle.template", form);
    		}
    	}
    }