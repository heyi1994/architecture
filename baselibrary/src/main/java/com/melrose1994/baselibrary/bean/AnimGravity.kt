package com.melrose1994.baselibrary.bean

/**
 * @property BI_BO 下进下出 ;
 * @property BI_TO 下进上出 ;
 * @property TI_TO 上进上出 ;
 * @property TI_BO 上进下出 ;
 * @property CUSTOM 自定义 ;
 * @property LI_RO 左进右出 ;
 * @property LI_LO 左进左出 ;
 * @property RI_RO 右进右出 ;
 * @property RI_LO 右进左出 ;
 * @property DEFAULT 系统默认动画 ;
 * @author Melrose
 * @since 1.0.0
 */
enum class AnimGravity {
    BI_BO, BI_TO,
    TI_TO, TI_BO,
    CUSTOM,DEFAULT,
    LI_RO,LI_LO,
    RI_RO,RI_LO
}