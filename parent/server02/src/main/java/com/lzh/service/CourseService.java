package com.lzh.service;

import com.lzh.client.Server01Client;
import com.lzh.dao.CourseRepository;
import com.lzh.domain.course.Course;
import com.lzh.domain.user.User;
import com.lzh.domain.user.UserResponseResult;
import com.lzh.domain.user.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

  /*  @Autowired
    private RestTemplate restTemplate;
*/
    @Autowired
    private DiscoveryClient discoveryClient;// Eureka客户端，可以获取到服务实例信息

    public Course getCourseById(Integer id) {
        Optional<Course> option = courseRepository.findById(id);
        if (option.isPresent()) {
            return option.get();
        }
        return null;
    }

   /* public Map getCourseAndUser() {
        List<User> users = null;
        try {
            //获取所有用户
            String url = "http://localhost:10086/server01/user/getAllUser";
            users = this.restTemplate.getForObject(url, ArrayList.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            HashMap<Object, Object> map = new HashMap<>();
            map.put("ERROR_MSG", "服务器连接失败：" + e.toString());
            return map;
        }
        //获取所有课程
        List<Course> courses = courseRepository.findAll();
        //封装到Map
        HashMap<Object, Object> map = new HashMap<>();
        map.put("users", users);
        map.put("courses", courses);
        return map;
    }*/

 /*   public Map getCourseAndUser2() {
        List<ServiceInstance> instances = discoveryClient.getInstances("server01");
        ServiceInstance instance = instances.get(0);
        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/server01/user/getAllUser";
        List users = this.restTemplate.getForObject(url, ArrayList.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("users",users);
        return map;
    }*/

    /**
     * 通过
     * @return
     */
  /*  public Map getCourseAndUser3() {
        String url = "http://server01/server01/user/getAllUser";
        ArrayList users = this.restTemplate.getForObject(url, ArrayList.class);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("users",users);
        return map;
    }*/

    @Autowired
    private Server01Client server01Client;

    /**
     * 通过feign调用server01服务的接口
     * @return
     */
    public Map getCourseAndUser4() {
        UserResponseResult userResponseResult = server01Client.getAllUser();
        List<User> users = userResponseResult.getList();
        HashMap<Object, Object> map = new HashMap<>();
        map.put("users",users);
        return map;
    }

    public void saveOrUpdateCourse(Course course) {
        //pojo里面有id，且id在库中存在，就是更新，否则就是新增
        courseRepository.save(course);
    }


    public UserResult getUserById(String id) {
        return server01Client.getUserById(id);

    }
}
