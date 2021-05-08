package com.jsm.provider.user.struct;

import com.jsm.provider.user.dto.UserDTO;
import com.jsm.provider.user.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserStruct {

    UserStruct INSTANCE = Mappers.getMapper(UserStruct.class);

    /**
     * 转vo
     * @param dto .
     * @author jinshengming
     * @date 2021/5/8 17:40
     * @return {com.jsm.provider.user.vo.UserVO}
     */
    UserVO toVO(UserDTO dto);

}
