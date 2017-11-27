package ua.yevhenii.servlet;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

@RestController
public class SeviceREST {

    private static final String template = "Hello, %s!";

    @RequestMapping(value = "/getsomedata", method = RequestMethod.POST)
    protected String get(@RequestParam(value = "name") String name)  {
        return String.format(template, name);
    }

    @RequestMapping(value = "/gethello", method = RequestMethod.GET)
    protected String getHello() {
        return "Hello, world!";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody String handleFileUpload(
            @RequestParam("file") MultipartFile file){

        if (!file.isEmpty()) {
            String name = file.getOriginalFilename();
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded file into " + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload file because the file input was empty.";
        }
    }

    @RequestMapping(value = "/download", produces = MediaType.ALL_VALUE)
    HttpEntity<byte[]> getFile(
            @RequestParam(value = "name") String name) throws IOException {

        byte[] file= Files.readAllBytes(Paths.get(name));
        HttpHeaders header = new HttpHeaders();
        header.set("Content-Disposition", "attachment; filename=" + name);
        header.setContentLength(file.length);

        return new HttpEntity<>(file, header);
    }
}
