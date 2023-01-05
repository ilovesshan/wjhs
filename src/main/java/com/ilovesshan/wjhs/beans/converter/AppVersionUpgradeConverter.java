package com.ilovesshan.wjhs.beans.converter;

import com.ilovesshan.wjhs.beans.dto.AppVersionUpgradeDto;
import com.ilovesshan.wjhs.beans.pojo.AppVersionUpgrade;
import com.ilovesshan.wjhs.beans.vo.AppVersionUpgradeVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2022/11/30
 * @description:
 */

@Component
@Mapper(componentModel = "spring")
public interface AppVersionUpgradeConverter {

    AppVersionUpgradeVo po2vo(AppVersionUpgrade appVersionUpgrade);

    AppVersionUpgrade dto2po(AppVersionUpgradeDto appVersionUpgradeDto);
}
