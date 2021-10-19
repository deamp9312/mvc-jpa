# mvc-jpa

이틀에 걸쳐서 Mvc 패턴 패턴 하는데,,, get post만 사용해 봤지 put이나 delete는 사용해 본적이 없었던거 같아서,,, 이번기회에 기존에 만들었던 소스코드를 보며,,,

그때와 다른 지식으로(발전된?) 게시판이니까 처음부터 다시 만들었습니다.

이번에는 boardService의 메소드들을 만들때 crud에 맞쳐 필요한 기능을 만들고 junit으로 test코드도 만들어 보면서 먼저 기능이 정상적으로 잘 작동하는지 먼저 확인해 보았습니다,

잘 되는것을 확인하고

put deletemapping을 사용할때 처음 밑의 오류를 만나게 되었고,, 구글링을 통해 톰켓이 기본적으로 post get 외 막아두었다는것을 알게 되었고,,,,

---
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Tue Oct 19 16:12:09 KST 2021

There was an unexpected error (type=Internal Server Error, status=500).

An error happened during template parsing (template: "class path resource [templates/boards/boardEdit.html]")

org.thymeleaf.exceptions.TemplateInputException: An error happened during template parsing (template: "class path resource [templates/boards/boardEdit.html]")
---

application.properties에 다음을 추가해야 get post외 사용이 가능합니다! spring.mvc.hiddenmethod.filter.enabled=true

그 뒤에는 form에 post로 받는곳 밑에 해당 put delete을 value에 넣고 하면 잘 동작하는것을 확인했습니다.
<input type="hidden" name="_method" value="put"/>


Ps..
간단한 crud지만 만들어보며 처음에는 동작원리도 모르고 만들어보고 왜 안되지 하며 강의등을 보며 만든 소스코드랑 비교해보고,,, 구글링하고 하면서 기능완성만 초점을 두었다면,,

이번에는 거이 구글링없이 본인의 생각대로 한번 작성해 보았습니다(타임리프 문법은 약해서 참고했습니다).
