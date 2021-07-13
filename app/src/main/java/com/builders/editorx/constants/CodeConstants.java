package com.builders.editorx.constants;

import android.graphics.Color;

import com.builders.editorx.AppController;
import com.builders.editorx.R;
import com.builders.editorx.modal.TagModel;

import java.util.ArrayList;
import java.util.List;

public class CodeConstants {

    private static int normalColor = -1;

    public static List<TagModel> tagList;

    public static void init() {
        normalColor = Color.GREEN;
        normalColor = 0xFFFF7F50;

        tagList = new ArrayList<>();
        addOpening();
        addClosing();
        setAttributes();
        addEnd();
    }

    private static void addOpening() {
        tagList.add(new TagModel("<!–-", normalColor));
        tagList.add(new TagModel("<!DOCTYPE html>", normalColor));
        tagList.add(new TagModel("<a>", normalColor));
        tagList.add(new TagModel("<abbr>", normalColor));
        tagList.add(new TagModel("<address>", normalColor));
        tagList.add(new TagModel("<area>", normalColor));
        tagList.add(new TagModel("<article>", normalColor));
        tagList.add(new TagModel("<aside>", normalColor));
        tagList.add(new TagModel("<audio>", normalColor));
        tagList.add(new TagModel("<b>", normalColor));
        tagList.add(new TagModel("<base>", normalColor));
        tagList.add(new TagModel("<bdi>", normalColor));
        tagList.add(new TagModel("<bdo>", normalColor));
        tagList.add(new TagModel("<blockquote>", normalColor));
        tagList.add(new TagModel("<body>", normalColor));
        tagList.add(new TagModel("<br>", normalColor));
        tagList.add(new TagModel("<button>", normalColor));
        tagList.add(new TagModel("<canvas>", normalColor));
        tagList.add(new TagModel("<caption>", normalColor));
        tagList.add(new TagModel("<cite>", normalColor));
        tagList.add(new TagModel("<code>", normalColor));
        tagList.add(new TagModel("<col>", normalColor));
        tagList.add(new TagModel("<colgroup>", normalColor));
        tagList.add(new TagModel("<data>", normalColor));
        tagList.add(new TagModel("<dd>", normalColor));
        tagList.add(new TagModel("<del>", normalColor));
        tagList.add(new TagModel("<details>", normalColor));
        tagList.add(new TagModel("<dfn>", normalColor));
        tagList.add(new TagModel("<dialog>", normalColor));
        tagList.add(new TagModel("<div>", normalColor));
        tagList.add(new TagModel("<dl>", normalColor));
        tagList.add(new TagModel("<dt>", normalColor));
        tagList.add(new TagModel("<em>", normalColor));
        tagList.add(new TagModel("<strong>", normalColor));
        tagList.add(new TagModel("<embed>", normalColor));
        tagList.add(new TagModel("<fieldset>", normalColor));
        tagList.add(new TagModel("<figure>", normalColor));
        tagList.add(new TagModel("<footer>", normalColor));
        tagList.add(new TagModel("<form>", normalColor));
        tagList.add(new TagModel("<h1>", normalColor));
        tagList.add(new TagModel("<h2>", normalColor));
        tagList.add(new TagModel("<h3>", normalColor));
        tagList.add(new TagModel("<h4>", normalColor));
        tagList.add(new TagModel("<h5>", normalColor));
        tagList.add(new TagModel("<h6>", normalColor));
        tagList.add(new TagModel("<head>", normalColor));
        tagList.add(new TagModel("<header>", normalColor));
        tagList.add(new TagModel("<hgroup>", normalColor));
        tagList.add(new TagModel("<html>", normalColor));
        tagList.add(new TagModel("<i>", normalColor));
        tagList.add(new TagModel("<iframe>", normalColor));
        tagList.add(new TagModel("<img>", normalColor));
        tagList.add(new TagModel("<input>", normalColor));
        tagList.add(new TagModel("<ins>", normalColor));
        tagList.add(new TagModel("<kbd>", normalColor));
        tagList.add(new TagModel("<keygen>", normalColor));
        tagList.add(new TagModel("<label>", normalColor));
        tagList.add(new TagModel("<legend>", normalColor));
        tagList.add(new TagModel("<li>", normalColor));
        tagList.add(new TagModel("<link>", normalColor));
        tagList.add(new TagModel("<main>", normalColor));
        tagList.add(new TagModel("<map>", normalColor));
        tagList.add(new TagModel("<mark>", normalColor));
        tagList.add(new TagModel("<menu>", normalColor));
        tagList.add(new TagModel("<menuitem>", normalColor));
        tagList.add(new TagModel("<meta>", normalColor));
        tagList.add(new TagModel("<meter>", normalColor));
        tagList.add(new TagModel("<nav>", normalColor));
        tagList.add(new TagModel("<noscript>", normalColor));
        tagList.add(new TagModel("<object>", normalColor));
        tagList.add(new TagModel("<ol>", normalColor));
        tagList.add(new TagModel("<optgroup>", normalColor));
        tagList.add(new TagModel("<option>", normalColor));
        tagList.add(new TagModel("<output>", normalColor));
        tagList.add(new TagModel("<p>", normalColor));
        tagList.add(new TagModel("<param>", normalColor));
        tagList.add(new TagModel("<pre>", normalColor));
        tagList.add(new TagModel("<progress>", normalColor));
        tagList.add(new TagModel("<q>", normalColor));
        tagList.add(new TagModel("<rb>", normalColor));
        tagList.add(new TagModel("<rp>", normalColor));
        tagList.add(new TagModel("<rt>", normalColor));
        tagList.add(new TagModel("<rtc>", normalColor));
        tagList.add(new TagModel("<ruby>", normalColor));
        tagList.add(new TagModel("<s>", normalColor));
        tagList.add(new TagModel("<samp>", normalColor));
        tagList.add(new TagModel("<script>", normalColor));
        tagList.add(new TagModel("<section>", normalColor));
        tagList.add(new TagModel("<select>", normalColor));
        tagList.add(new TagModel("<small>", normalColor));
        tagList.add(new TagModel("<source>", normalColor));
        tagList.add(new TagModel("<span>", normalColor));
        tagList.add(new TagModel("<strong>", normalColor));
        tagList.add(new TagModel("<style>", normalColor));
        tagList.add(new TagModel("<sub>", normalColor));
        tagList.add(new TagModel("<summary>", normalColor));
        tagList.add(new TagModel("<sup>", normalColor));
        tagList.add(new TagModel("<table>", normalColor));
        tagList.add(new TagModel("<tbody>", normalColor));
        tagList.add(new TagModel("<td>", normalColor));
        tagList.add(new TagModel("<template>", normalColor));
        tagList.add(new TagModel("<textarea>", normalColor));
        tagList.add(new TagModel("<tfoot>", normalColor));
        tagList.add(new TagModel("<th>", normalColor));
        tagList.add(new TagModel("<thead>", normalColor));
        tagList.add(new TagModel("<time>", normalColor));
        tagList.add(new TagModel("<title>", normalColor));
        tagList.add(new TagModel("<tr>", normalColor));
        tagList.add(new TagModel("<track>", normalColor));
        tagList.add(new TagModel("<u>", normalColor));
        tagList.add(new TagModel("<ul>", normalColor));
        tagList.add(new TagModel("<var>", normalColor));
        tagList.add(new TagModel("<video>", normalColor));
        tagList.add(new TagModel("<wbr>", normalColor));

        tagList.add(new TagModel("<a", normalColor));
        tagList.add(new TagModel("<abbr", normalColor));
        tagList.add(new TagModel("<address", normalColor));
        tagList.add(new TagModel("<area", normalColor));
        tagList.add(new TagModel("<article", normalColor));
        tagList.add(new TagModel("<aside", normalColor));
        tagList.add(new TagModel("<audio", normalColor));
        tagList.add(new TagModel("<b", normalColor));
        tagList.add(new TagModel("<base", normalColor));
        tagList.add(new TagModel("<bdi", normalColor));
        tagList.add(new TagModel("<bdo", normalColor));
        tagList.add(new TagModel("<blockquote", normalColor));
        tagList.add(new TagModel("<body", normalColor));
        tagList.add(new TagModel("<br", normalColor));
        tagList.add(new TagModel("<button", normalColor));
        tagList.add(new TagModel("<canvas", normalColor));
        tagList.add(new TagModel("<caption", normalColor));
        tagList.add(new TagModel("<cite", normalColor));
        tagList.add(new TagModel("<code", normalColor));
        tagList.add(new TagModel("<col", normalColor));
        tagList.add(new TagModel("<colgroup", normalColor));
        tagList.add(new TagModel("<data", normalColor));
        tagList.add(new TagModel("<dd", normalColor));
        tagList.add(new TagModel("<del", normalColor));
        tagList.add(new TagModel("<details", normalColor));
        tagList.add(new TagModel("<dfn", normalColor));
        tagList.add(new TagModel("<dialog", normalColor));
        tagList.add(new TagModel("<div", normalColor));
        tagList.add(new TagModel("<dl", normalColor));
        tagList.add(new TagModel("<dt", normalColor));
        tagList.add(new TagModel("<em", normalColor));
        tagList.add(new TagModel("<strong", normalColor));
        tagList.add(new TagModel("<embed", normalColor));
        tagList.add(new TagModel("<fieldset", normalColor));
        tagList.add(new TagModel("<figure", normalColor));
        tagList.add(new TagModel("<footer", normalColor));
        tagList.add(new TagModel("<form", normalColor));
        tagList.add(new TagModel("<h1", normalColor));
        tagList.add(new TagModel("<h2", normalColor));
        tagList.add(new TagModel("<h3", normalColor));
        tagList.add(new TagModel("<h4", normalColor));
        tagList.add(new TagModel("<h5", normalColor));
        tagList.add(new TagModel("<h6", normalColor));
        tagList.add(new TagModel("<head", normalColor));
        tagList.add(new TagModel("<header", normalColor));
        tagList.add(new TagModel("<hgroup", normalColor));
        tagList.add(new TagModel("<html", normalColor));
        tagList.add(new TagModel("<i", normalColor));
        tagList.add(new TagModel("<iframe", normalColor));
        tagList.add(new TagModel("<img", normalColor));
        tagList.add(new TagModel("<input", normalColor));
        tagList.add(new TagModel("<ins", normalColor));
        tagList.add(new TagModel("<kbd", normalColor));
        tagList.add(new TagModel("<keygen", normalColor));
        tagList.add(new TagModel("<label", normalColor));
        tagList.add(new TagModel("<legend", normalColor));
        tagList.add(new TagModel("<li", normalColor));
        tagList.add(new TagModel("<link", normalColor));
        tagList.add(new TagModel("<main", normalColor));
        tagList.add(new TagModel("<map", normalColor));
        tagList.add(new TagModel("<mark", normalColor));
        tagList.add(new TagModel("<menu", normalColor));
        tagList.add(new TagModel("<menuitem", normalColor));
        tagList.add(new TagModel("<meta", normalColor));
        tagList.add(new TagModel("<meter", normalColor));
        tagList.add(new TagModel("<nav", normalColor));
        tagList.add(new TagModel("<noscript", normalColor));
        tagList.add(new TagModel("<object", normalColor));
        tagList.add(new TagModel("<ol", normalColor));
        tagList.add(new TagModel("<optgroup", normalColor));
        tagList.add(new TagModel("<option", normalColor));
        tagList.add(new TagModel("<output", normalColor));
        tagList.add(new TagModel("<p", normalColor));
        tagList.add(new TagModel("<param", normalColor));
        tagList.add(new TagModel("<pre", normalColor));
        tagList.add(new TagModel("<progress", normalColor));
        tagList.add(new TagModel("<q", normalColor));
        tagList.add(new TagModel("<rb", normalColor));
        tagList.add(new TagModel("<rp", normalColor));
        tagList.add(new TagModel("<rt", normalColor));
        tagList.add(new TagModel("<rtc", normalColor));
        tagList.add(new TagModel("<ruby", normalColor));
        tagList.add(new TagModel("<s", normalColor));
        tagList.add(new TagModel("<samp", normalColor));
        tagList.add(new TagModel("<script", normalColor));
        tagList.add(new TagModel("<section", normalColor));
        tagList.add(new TagModel("<select", normalColor));
        tagList.add(new TagModel("<small", normalColor));
        tagList.add(new TagModel("<source", normalColor));
        tagList.add(new TagModel("<span", normalColor));
        tagList.add(new TagModel("<strong", normalColor));
        tagList.add(new TagModel("<style", normalColor));
        tagList.add(new TagModel("<sub", normalColor));
        tagList.add(new TagModel("<summary", normalColor));
        tagList.add(new TagModel("<sup", normalColor));
        tagList.add(new TagModel("<table", normalColor));
        tagList.add(new TagModel("<tbody", normalColor));
        tagList.add(new TagModel("<td", normalColor));
        tagList.add(new TagModel("<template", normalColor));
        tagList.add(new TagModel("<textarea", normalColor));
        tagList.add(new TagModel("<tfoot", normalColor));
        tagList.add(new TagModel("<th", normalColor));
        tagList.add(new TagModel("<thead", normalColor));
        tagList.add(new TagModel("<time", normalColor));
        tagList.add(new TagModel("<title", normalColor));
        tagList.add(new TagModel("<tr", normalColor));
        tagList.add(new TagModel("<track", normalColor));
        tagList.add(new TagModel("<u", normalColor));
        tagList.add(new TagModel("<ul", normalColor));
        tagList.add(new TagModel("<var", normalColor));
        tagList.add(new TagModel("<video", normalColor));
        tagList.add(new TagModel("<wbr", normalColor));

    }

    private static void addClosing() {
        tagList.add(new TagModel("</abbr>", normalColor));
        tagList.add(new TagModel("</address>", normalColor));
        tagList.add(new TagModel("</area>", normalColor));
        tagList.add(new TagModel("</article>", normalColor));
        tagList.add(new TagModel("</aside>", normalColor));
        tagList.add(new TagModel("</audio>", normalColor));
        tagList.add(new TagModel("</b>", normalColor));
        tagList.add(new TagModel("</base>", normalColor));
        tagList.add(new TagModel("</bdi>", normalColor));
        tagList.add(new TagModel("</bdo>", normalColor));
        tagList.add(new TagModel("</blockquote>", normalColor));
        tagList.add(new TagModel("</body>", normalColor));
        tagList.add(new TagModel("</br>", normalColor));
        tagList.add(new TagModel("</button>", normalColor));
        tagList.add(new TagModel("</canvas>", normalColor));
        tagList.add(new TagModel("</caption>", normalColor));
        tagList.add(new TagModel("</cite>", normalColor));
        tagList.add(new TagModel("</code>", normalColor));
        tagList.add(new TagModel("</col>", normalColor));
        tagList.add(new TagModel("</colgroup>", normalColor));
        tagList.add(new TagModel("</data>", normalColor));
        tagList.add(new TagModel("</dd>", normalColor));
        tagList.add(new TagModel("</del>", normalColor));
        tagList.add(new TagModel("</details>", normalColor));
        tagList.add(new TagModel("</dfn>", normalColor));
        tagList.add(new TagModel("</dialog>", normalColor));
        tagList.add(new TagModel("</div>", normalColor));
        tagList.add(new TagModel("</dl>", normalColor));
        tagList.add(new TagModel("</dt>", normalColor));
        tagList.add(new TagModel("</em>", normalColor));
        tagList.add(new TagModel("</strong>", normalColor));
        tagList.add(new TagModel("</embed>", normalColor));
        tagList.add(new TagModel("</fieldset>", normalColor));
        tagList.add(new TagModel("</figure>", normalColor));
        tagList.add(new TagModel("</footer>", normalColor));
        tagList.add(new TagModel("</form>", normalColor));
        tagList.add(new TagModel("</h1>", normalColor));
        tagList.add(new TagModel("</h2>", normalColor));
        tagList.add(new TagModel("</h3>", normalColor));
        tagList.add(new TagModel("</h4>", normalColor));
        tagList.add(new TagModel("</h5>", normalColor));
        tagList.add(new TagModel("</h6>", normalColor));
        tagList.add(new TagModel("</head>", normalColor));
        tagList.add(new TagModel("</header>", normalColor));
        tagList.add(new TagModel("</hgroup>", normalColor));
        tagList.add(new TagModel("</html>", normalColor));
        tagList.add(new TagModel("</i>", normalColor));
        tagList.add(new TagModel("</iframe>", normalColor));
        tagList.add(new TagModel("</img>", normalColor));
        tagList.add(new TagModel("</input>", normalColor));
        tagList.add(new TagModel("</ins>", normalColor));
        tagList.add(new TagModel("</kbd>", normalColor));
        tagList.add(new TagModel("</keygen>", normalColor));
        tagList.add(new TagModel("</label>", normalColor));
        tagList.add(new TagModel("</legend>", normalColor));
        tagList.add(new TagModel("</li>", normalColor));
        tagList.add(new TagModel("</link>", normalColor));
        tagList.add(new TagModel("</main>", normalColor));
        tagList.add(new TagModel("</map>", normalColor));
        tagList.add(new TagModel("</mark>", normalColor));
        tagList.add(new TagModel("</menu>", normalColor));
        tagList.add(new TagModel("</menuitem>", normalColor));
        tagList.add(new TagModel("</meta>", normalColor));
        tagList.add(new TagModel("</meter>", normalColor));
        tagList.add(new TagModel("</nav>", normalColor));
        tagList.add(new TagModel("</noscript>", normalColor));
        tagList.add(new TagModel("</object>", normalColor));
        tagList.add(new TagModel("</ol>", normalColor));
        tagList.add(new TagModel("</optgroup>", normalColor));
        tagList.add(new TagModel("</option>", normalColor));
        tagList.add(new TagModel("</output>", normalColor));
        tagList.add(new TagModel("</p>", normalColor));
        tagList.add(new TagModel("</param>", normalColor));
        tagList.add(new TagModel("</pre>", normalColor));
        tagList.add(new TagModel("</progress>", normalColor));
        tagList.add(new TagModel("</q>", normalColor));
        tagList.add(new TagModel("</rb>", normalColor));
        tagList.add(new TagModel("</rp>", normalColor));
        tagList.add(new TagModel("</rt>", normalColor));
        tagList.add(new TagModel("</rtc>", normalColor));
        tagList.add(new TagModel("</ruby>", normalColor));
        tagList.add(new TagModel("</s>", normalColor));
        tagList.add(new TagModel("</samp>", normalColor));
        tagList.add(new TagModel("</script>", normalColor));
        tagList.add(new TagModel("</section>", normalColor));
        tagList.add(new TagModel("</select>", normalColor));
        tagList.add(new TagModel("</small>", normalColor));
        tagList.add(new TagModel("</source>", normalColor));
        tagList.add(new TagModel("</span>", normalColor));
        tagList.add(new TagModel("</strong>", normalColor));
        tagList.add(new TagModel("</style>", normalColor));
        tagList.add(new TagModel("</sub>", normalColor));
        tagList.add(new TagModel("</summary>", normalColor));
        tagList.add(new TagModel("</sup>", normalColor));
        tagList.add(new TagModel("</table>", normalColor));
        tagList.add(new TagModel("</tbody>", normalColor));
        tagList.add(new TagModel("</td>", normalColor));
        tagList.add(new TagModel("</template>", normalColor));
        tagList.add(new TagModel("</textarea>", normalColor));
        tagList.add(new TagModel("</tfoot>", normalColor));
        tagList.add(new TagModel("</th>", normalColor));
        tagList.add(new TagModel("</thead>", normalColor));
        tagList.add(new TagModel("</time>", normalColor));
        tagList.add(new TagModel("</title>", normalColor));
        tagList.add(new TagModel("</tr>", normalColor));
        tagList.add(new TagModel("</track>", normalColor));
        tagList.add(new TagModel("</u>", normalColor));
        tagList.add(new TagModel("</ul>", normalColor));
        tagList.add(new TagModel("</var>", normalColor));
        tagList.add(new TagModel("</video>", normalColor));
        tagList.add(new TagModel("</wbr>", normalColor));
        tagList.add(new TagModel("</a>", normalColor));

    }

    private static void setAttributes() {

        tagList.add(new TagModel("dir", normalColor));
        tagList.add(new TagModel("xml:lang", normalColor));

        tagList.add(new TagModel("accept", normalColor));
        tagList.add(new TagModel("accept-charset", normalColor));
        tagList.add(new TagModel("accesskey", normalColor));
        tagList.add(new TagModel("action", normalColor));
        tagList.add(new TagModel("align", normalColor));
        tagList.add(new TagModel("allow", normalColor));
        tagList.add(new TagModel("alt", normalColor));
        tagList.add(new TagModel("async", normalColor));
        tagList.add(new TagModel("autocomplete", normalColor));
        tagList.add(new TagModel("autocapitalize", normalColor));
        tagList.add(new TagModel("autofocus", normalColor));
        tagList.add(new TagModel("autoplay", normalColor));
        tagList.add(new TagModel("background", normalColor));
        tagList.add(new TagModel("bgcolor", normalColor));
        tagList.add(new TagModel("border", normalColor));

        // Event Attributes
        tagList.add(new TagModel("onclick", normalColor));
        tagList.add(new TagModel("ondblclick", normalColor));
        tagList.add(new TagModel("onmousedown", normalColor));
        tagList.add(new TagModel("onmouseup", normalColor));
        tagList.add(new TagModel("onmouseover", normalColor));
        tagList.add(new TagModel("onmouseout", normalColor));
        tagList.add(new TagModel("onkeypress", normalColor));
        tagList.add(new TagModel("onkeydown", normalColor));
        tagList.add(new TagModel("onkeyup", normalColor));
        tagList.add(new TagModel("buffered", normalColor));
        tagList.add(new TagModel("capture", normalColor));
        tagList.add(new TagModel("challenge", normalColor));
        tagList.add(new TagModel("charset", normalColor));
        tagList.add(new TagModel("checked", normalColor));
        tagList.add(new TagModel("cite", normalColor));
        tagList.add(new TagModel("class", normalColor));
        tagList.add(new TagModel("code", normalColor));
        tagList.add(new TagModel("codebase", normalColor));
        tagList.add(new TagModel("color", normalColor));
        tagList.add(new TagModel("cols", normalColor));
        tagList.add(new TagModel("colspan", normalColor));
        tagList.add(new TagModel("content", normalColor));
        tagList.add(new TagModel("contenteditable", normalColor));
        tagList.add(new TagModel("contextmenu", normalColor));
        tagList.add(new TagModel("controls", normalColor));
        tagList.add(new TagModel("coords", normalColor));
        tagList.add(new TagModel("crossorigin", normalColor));
        tagList.add(new TagModel("csp", normalColor));
        tagList.add(new TagModel("data", normalColor));
        tagList.add(new TagModel("datetime", normalColor));
        tagList.add(new TagModel("decoding", normalColor));
        tagList.add(new TagModel("default", normalColor));
        tagList.add(new TagModel("defer", normalColor));
        tagList.add(new TagModel("dir", normalColor));
        tagList.add(new TagModel("dirname", normalColor));
        tagList.add(new TagModel("download", normalColor));
        tagList.add(new TagModel("disabled", normalColor));
        tagList.add(new TagModel("draggable", normalColor));
        tagList.add(new TagModel("enctype", normalColor));
        tagList.add(new TagModel("for", normalColor));
        tagList.add(new TagModel("form", normalColor));
        tagList.add(new TagModel("formaction", normalColor));
        tagList.add(new TagModel("formenctype", normalColor));
        tagList.add(new TagModel("formmethod", normalColor));
        tagList.add(new TagModel("formnovalidate", normalColor));
        tagList.add(new TagModel("formtarget", normalColor));
        tagList.add(new TagModel("headers", normalColor));
        tagList.add(new TagModel("height", normalColor));
        tagList.add(new TagModel("hidden", normalColor));
        tagList.add(new TagModel("high", normalColor));
        tagList.add(new TagModel("href", normalColor));
        tagList.add(new TagModel("hreflang", normalColor));
        tagList.add(new TagModel("http-equiv", normalColor));
        tagList.add(new TagModel("icon", normalColor));
        tagList.add(new TagModel("id", normalColor));
        tagList.add(new TagModel("importance", normalColor));
        tagList.add(new TagModel("integrity", normalColor));
        tagList.add(new TagModel("intrinsicsize", normalColor));
        tagList.add(new TagModel("inputmode", normalColor));
        tagList.add(new TagModel("ismap", normalColor));
        tagList.add(new TagModel("itemprop", normalColor));
        tagList.add(new TagModel("keytype", normalColor));
        tagList.add(new TagModel("kind", normalColor));
        tagList.add(new TagModel("label", normalColor));
        tagList.add(new TagModel("lang", normalColor));
        tagList.add(new TagModel("language", normalColor));
        tagList.add(new TagModel("loading", normalColor));
        tagList.add(new TagModel("list", normalColor));
        tagList.add(new TagModel("loop", normalColor));
        tagList.add(new TagModel("low", normalColor));
        tagList.add(new TagModel("manifest", normalColor));
        tagList.add(new TagModel("max", normalColor));
        tagList.add(new TagModel("maxlength", normalColor));
        tagList.add(new TagModel("minlength", normalColor));
        tagList.add(new TagModel("media", normalColor));
        tagList.add(new TagModel("method", normalColor));
        tagList.add(new TagModel("min", normalColor));
        tagList.add(new TagModel("multiple", normalColor));
        tagList.add(new TagModel("muted", normalColor));
        tagList.add(new TagModel("name", normalColor));
        tagList.add(new TagModel("novalidate", normalColor));
        tagList.add(new TagModel("open", normalColor));
        tagList.add(new TagModel("optimum", normalColor));
        tagList.add(new TagModel("pattern", normalColor));
        tagList.add(new TagModel("ping", normalColor));
        tagList.add(new TagModel("placeholder", normalColor));
        tagList.add(new TagModel("poster", normalColor));
        tagList.add(new TagModel("preload", normalColor));
        tagList.add(new TagModel("radiogroup", normalColor));
        tagList.add(new TagModel("readonly", normalColor));
        tagList.add(new TagModel("referrerpolicy", normalColor));
        tagList.add(new TagModel("rel", normalColor));
        tagList.add(new TagModel("required", normalColor));
        tagList.add(new TagModel("reversed", normalColor));
        tagList.add(new TagModel("rows", normalColor));
        tagList.add(new TagModel("rowspan", normalColor));
        tagList.add(new TagModel("sandbox", normalColor));
        tagList.add(new TagModel("scope", normalColor));
        tagList.add(new TagModel("scoped", normalColor));
        tagList.add(new TagModel("selected", normalColor));
        tagList.add(new TagModel("shape", normalColor));
        tagList.add(new TagModel("size", normalColor));
        tagList.add(new TagModel("sizes", normalColor));
        tagList.add(new TagModel("slot", normalColor));
        tagList.add(new TagModel("span", normalColor));
        tagList.add(new TagModel("spellcheck", normalColor));
        tagList.add(new TagModel("src", normalColor));
        tagList.add(new TagModel("srcdoc", normalColor));
        tagList.add(new TagModel("srcset", normalColor));
        tagList.add(new TagModel("srclang", normalColor));
        tagList.add(new TagModel("start", normalColor));
        tagList.add(new TagModel("step", normalColor));
        tagList.add(new TagModel("style", normalColor));
        tagList.add(new TagModel("summary", normalColor));
        tagList.add(new TagModel("tabindex", normalColor));
        tagList.add(new TagModel("target", normalColor));
        tagList.add(new TagModel("title", normalColor));
        tagList.add(new TagModel("translate", normalColor));
        tagList.add(new TagModel("type", normalColor));
        tagList.add(new TagModel("usemap", normalColor));
        tagList.add(new TagModel("value", normalColor));
        tagList.add(new TagModel("width", normalColor));
        tagList.add(new TagModel("wrap", normalColor));
    }

    private static void addEnd() {
        int bracketColor = Color.GREEN;

        tagList.add(new TagModel("<", bracketColor));
        tagList.add(new TagModel("</", bracketColor));
        tagList.add(new TagModel(">", bracketColor));

        tagList.add(new TagModel("=", normalColor));
        tagList.add(new TagModel("\"", normalColor));
    }
}