<img src="./res/images/ubml_logo.png"  height="100" width="426">

# UBML: Unified Business Modeling Language(统一业务建模语言)

[![license](https://img.shields.io/github/license/seata/seata.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)


## 简介

UBML是一种基于领域特定语言（Domain-Specific Language DSL）的、用于**快速构建**应用软件的**建模语言**。内容包括元模型标准及其默认实现、SDK、运行时框架等组件。UBML定位于aPaaS（应用程序平台即服务）领域，是低代码开发平台（Low-Code-Development-Platform）的**核心基础**，致力于在低代码领域建立应用软件建模开发的事实标准

### 架构图

UBML架构图如下

<img src="./res/images/ubml_architecture.jpg"  height="378" width="755">

### 特性
- 微内核可扩展的开放架构：元模型标准与实现解耦，元模型种类可以**按行业类型/应用类型持续扩展**
- 开发语言无关性：通过建模，可适配**多种技术栈实现**
- 全栈模型刻画能力：建模范围可涵盖UI、API、流程、领域服务、持久化等**全栈开发**的各个层级
- 支持Hybrid模式：开发模式上，提供**模型生成代码**与**模型动态解析**两种开发技术
- 模型工程化：视模型为源码，提供模型**生命周期管理**与**工程化管理**能力，可与主流研发工具融合，支持DevOps

### 价值
- 显著提升软件开发效率
- 最大程度减少人工编码的不规范性与出错率，促进软件开发标准化
- 降低开发门槛，促进软件开发平民化
- 丰富工业应用软件生态，赋能企业数字化创新转型

### 核心设计策略
<table>
<thead>
<tr>
<th>策略</th>
<th>说明</th>
</tr>
</thead>
<tbody>
<tr>
<td>开发语言无关性</td>
<td>元模型是一份抽象描述，与具体的编程语言无关，可以通过一份元模型适配多种开发语言</td>
</tr>
<tr>
<td>开放性</td>
<td>元模型具有开放性，可以根据具体需求扩展元模型的类型，元模型的设计应该支持这种开放性。SDK、Runtime服务，支持元模型类型的扩展</td>
</tr>
<tr>
<td>扩展性</td>
<td>元模型具有扩展性，提供基础的元模型实现，可以根据实际特殊需求对已有元模型进行扩展</td>
</tr>
<tr>
<td>分层复用设计</td>
<td>根据场景，元模型、公共组件、公共类型、基础机制形成分层的复用架构，支持元模型体系的分层复用。SDK、Runtime服务，遵循分层复用，内核有尽量少的的依赖，公共服务尽量复用</td>
</tr>
<tr>
<td>标准兼容适配</td>
<td>可以支持以UBML-Standard与其他领域具体标准适配，例如使用UBML能够描述BPMN模型、OpenAPI 3.0模型等</td>
</tr>
<tr>
<td>生态友好</td>
<td>具有良好的生态兼容性，复用性，UBML Common是一个复用基础层，支持各类新元模型的直接引用、组装复用</td>
</tr>
<tr>
<td>性能</td>
<td>在SDK中，提供必要缓存，提升生成与编译性能；在具体运行时服务中，提供必要的缓存</td>
</tr>
</tbody>
</table>

### 历史

##### GSP
2004-2019，浪潮上一代低代码开发平台GSP采用了模型驱动的低代码开发技术，其内置的模型体系是UBML的前身
##### iGIX
2019年，浪潮基于云原生、前后端分离、领域驱动设计、跨平台等架构与设计理念，形成UBML低代码建模体系，并应用于浪潮新一代企业数字化能力平台iGIX
#### UBML
2020年，浪潮将UBML低代码建模体系从iGIX剥离，启动开源进程，旨在将UBML打造成低代码领域的标准

## 如何使用

### 快速入门
有关UBML的快速入门教程，详见 [快速入门](http://open.inspur.com/open-igix/ubml/wikis/quick-start)

## 文档
您可以通过 [UBML wiki page](http://open.inspur.com/open-igix/ubml/wikis/home) 查看关于UBML的所有文档

### 新建Issue

请按照 [Issue模板](./.github/ISSUE_TEMPLATE/BUG_REPORT.md) 反馈您遇到的任何问题.

## 贡献
欢迎贡献者加入UBML项目！关于如何为UBML做出贡献，请参阅 [如何参与贡献](./CONTRIBUTING.md)。

## 许可证

UBML采用的开源许可证是Apache License 2.0，有关协议细节，请参阅 [LICENSE](./LICENSE) 
