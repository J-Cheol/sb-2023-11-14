package com.ll.sb20231114;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
// 컨트롤러 입니다. 어노테이션 - 주석 아래 클래스가 컨트롤러다라는 것을 알려줌
public class HomeController
{
    @GetMapping("/")
    @ResponseBody
        // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showMain()
    {
        return "안녕하세요.";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout()
    {
        return "개발자 커뮤니티";
    }

    @GetMapping("/calc")
    @ResponseBody
    String showCalc(int a, int b)
    {
        return "계산 결과 %d".formatted(a + b);
    }


    @GetMapping("/calc2")
    @ResponseBody
    String showCalc2(Integer a, Integer b)
    {
        return "a : " + a + ", b : " + b;
    }

    @GetMapping("/calc3")
    @ResponseBody
    String showCalc3(Integer a, Integer b)
    {
        return "계산 결과 %d".formatted(a * b);
    }

    @GetMapping("/calc4")
    @ResponseBody
    String showCalc4(double a, double b)
    {
        return "계산 결과 %f".formatted(a * b);
    }

    @GetMapping("/calc5")
    @ResponseBody
    String showCalc5
            (
                    @RequestParam(defaultValue = "0") int a,
                    @RequestParam(defaultValue = "0") int b
            )
    {
        return "계산 결과 %d".formatted(a * b);
    }

    @GetMapping("/calc6")
    @ResponseBody
    String showCalc6
            (
                    @RequestParam(defaultValue = "0") double a,
                    @RequestParam(defaultValue = "0") double b
            )
    {
        return "계산 결과 %f".formatted(a + b);
    }

    @GetMapping("/calc7")
    @ResponseBody
    String showCalc7
            (
                    @RequestParam(defaultValue = "-") String a,
                    @RequestParam(defaultValue = "-") String b
            )
    {
        return "계산 결과 %s".formatted(a + b);
    }

    @GetMapping("/calc8")
    @ResponseBody
    int showCalc8
            (
                    @RequestParam(defaultValue = "0") int a,
                    @RequestParam(defaultValue = "0") int b
            )
    {
        return a + b;
    }

    @GetMapping("/calc9")
    @ResponseBody
    boolean showCalc9
            (
                    @RequestParam(defaultValue = "0") int a,
                    @RequestParam(defaultValue = "0") int b
            )
    {
        return a > b;
    }

    @GetMapping("/calc10")
    @ResponseBody
    Person showCalc10
            (
                    String name, int age
            )
    {
        return new Person(name, age);
    }

    @GetMapping("/calc11")
    @ResponseBody
    Person2 showCalc11
            (
                    String name, int age
            )
    {
        return new Person2(name, age);
    }

    @GetMapping("/calc12")
    @ResponseBody
    List<Integer> showCalc12()
    {
        List<Integer> nums = new ArrayList<>()
        {{
            add(10);
            add(-510);
            add(10010);
        }};

        return nums;
    }

    @GetMapping("/calc13")
    @ResponseBody
    int[] showCalc13()
    {
        int[] nums = new int[]{10, -510, 10010};
        return nums;
    }

    @GetMapping("/calc14")
    @ResponseBody
    Map<String, Object> showCalc14
            (
                    String name, int age
            )
    {
        Map<String, Object> personMap = Map.of(
                "name", name,
                "age", age
        );

        return personMap;
    }

    @GetMapping("/calc15")
    @ResponseBody
    List<Person2> showCalc15
            (
                    String name, int age
            )
    {
        List<Person2> persons = new ArrayList<>()
        {{ // 생성자 익명클래스라 생성자도 이름이 없다.
            this.add(new Person2(name, age));
            this.add(new Person2(name + "!", +age + 1));
            this.add(new Person2(name + "!!", +age + 2));
        }};

        return persons;
    }

    @GetMapping("/calc16")
    @ResponseBody
    String showCalc16()
    {
        String html = "";

        html += "<div>";
        html += "<input type=\"text\" placeholder=\"내용\">";
        html += "</div>";
        return html;
    }

    @GetMapping("/calc17")
    @ResponseBody
    String showCalc17()
    {
        StringBuilder sb = new StringBuilder();

        sb.append("<div>");
        sb.append("<input type=\"text\" placeholder=\"내용\">");
        sb.append("</div>");
        return sb.toString();
    }

    @GetMapping("c/alc18")
    @ResponseBody
    String showCalc18()
    {
        String html = "<div><input type=\"text\" placeholder=\"내용\"></div>";

        return html;
    }

    @GetMapping("/calc19")
    @ResponseBody
    String showCalc19()
    {
        String html = """
                <div>
                    <input type=\"text\" placeholder=\"내용\">
                </div>"
                """;

        return html;
    }

    @GetMapping("/calc20")
    @ResponseBody
    String showCalc20()
    {
        String html = """
                <div>
                    <input type="text" placeholder="내용" value="반가워요.">
                </div>
                """;

        return html;
    }

    @GetMapping("/calc21")
    @ResponseBody
    String showCalc21(
            @RequestParam(defaultValue = "") String subject,
            @RequestParam(defaultValue = "") String content)
    {
        String html = """
                <div>
                    <input type="text" placeholder="제목" value="%s">
                </div>
                <div>
                    <input type="text" placeholder="내용" value="%s">
                </div>
                """.formatted(subject, content);

        return html;
    }

    @GetMapping("/calc22")
    String showCalc22()
    {
        return "calc22";
    }

    @GetMapping("/calc23")
    String showCalc23(Model model)
    {
        model.addAttribute("v1", "안녕");
        model.addAttribute("v2", "반가워");
        return "calc23";
    }
    int num = 0;
    @GetMapping("/calc24")
    @ResponseBody
    int showCalc24()
    {
        num++;
        return num;
    }

    @AllArgsConstructor
    class Person
    {
        public String name;
        public int age;
    }

    @AllArgsConstructor
    class Person2
    {
        @Getter
        private String name;
        @Getter
        private int age;
    }
}

