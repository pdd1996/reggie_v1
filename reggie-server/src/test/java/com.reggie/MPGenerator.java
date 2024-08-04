package com.reggie;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class MPGenerator {
    public static void main(String[] args) {
        AutoGenerator autoGenerator = new AutoGenerator();
        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        assembleDev(dataSourceConfig);
        autoGenerator.setDataSource(dataSourceConfig);

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOpen(false);
        // <------ 配置处1 配置路径 ------>
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/reggie-server/src/main/java");
        globalConfig.setAuthor("paddy");
        globalConfig.setServiceImplName("%sDao");
        autoGenerator.setGlobalConfig(globalConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        // 包路径
        // <------ 配置处2 包路径 ------>
        packageConfig.setParent("com.reggie.employee");
        packageConfig.setEntity("domain.entity");
        packageConfig.setMapper("mapper");
        packageConfig.setController("controller");
        packageConfig.setServiceImpl("dao");
        autoGenerator.setPackageInfo(packageConfig);

        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setEntityLombokModel(true);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityTableFieldAnnotationEnable(true);

        // 重点:操作哪些表 可以传多个
        // <------ 配置处3 操作表 ------>
        strategyConfig.setInclude("employee");

        // 自动填充
        List<TableFill> list = new ArrayList<TableFill>();
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        list.add(createTime);
        list.add(updateTime);

        autoGenerator.setStrategy(strategyConfig);

        // 执行
        autoGenerator.execute();
    }

    private static void assembleDev(DataSourceConfig dataSourceConfig) {
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setUrl("jdbc:mysql://47.96.75.90:3306/reggie?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC");
    }
}
