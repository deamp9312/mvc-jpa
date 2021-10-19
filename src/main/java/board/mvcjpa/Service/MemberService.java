package board.mvcjpa.Service;

import board.mvcjpa.Repository.MemberJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberJPARepository memberJPARepository;



}
