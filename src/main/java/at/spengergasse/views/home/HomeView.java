package at.spengergasse.views.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.HOME_SOLID)
public class HomeView extends VerticalLayout {

    public HomeView() {
        setSpacing(true);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(getHeader());

        Image img = new Image("images/logo.png", "the logo of Griesy Pizza");
        img.setWidth("200px");
        img.setHeight("100px");

        Paragraph description = new Paragraph("Griesy Pizza is a rich, indulgent pizza known for its extra cheese and slightly oily, flavorful topping layer. It features a crispy yet soft crust, loaded with melted cheese that creates a satisfying stretch, and toppings that release delicious juices, giving it that signature “greasy” shine. Perfect for those who love bold taste and a comforting, hearty bite.");
        description.setWidth("500px");
        description.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        HorizontalLayout desc = new HorizontalLayout(img, description);
        add (desc);

        H3 name = new H3("Griesy Pizza GmbH");
        H3 street = new H3("Spengergasse 20");
        H3 city = new H3("1050 Vienna");

        HorizontalLayout adress = new HorizontalLayout(name, street, city);
        adress.getStyle().set("gap", "40px");
        add (adress);
    }

    public static Component getHeader() {
        VerticalLayout header;

        H1 companyName = new H1("Griesy Pizza");
        companyName.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "6rem")
                .set("margin", "0");

        H2 subtitle = new H2("... the best pizza in the world ...");
        subtitle.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        header = new VerticalLayout(companyName, subtitle);
        header.setSpacing(false);
        header.setPadding(false);
        header.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        return header;
    }
}
